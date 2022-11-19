package com.uob.smilegame.smilegame.repository.impl;

import com.uob.smilegame.smilegame.constant.database.ScoreBordTableConstant;
import com.uob.smilegame.smilegame.dto.ScoreBoardDto;
import com.uob.smilegame.smilegame.mapper.ScoreBoardDetailRowMapper;
import com.uob.smilegame.smilegame.mapper.ScoreBordRowMapper;
import com.uob.smilegame.smilegame.mapper.UserRowMapper;
import com.uob.smilegame.smilegame.repository.ScoreBordRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;

import static com.uob.smilegame.smilegame.constant.database.ScoreBordTableConstant.*;
import static com.uob.smilegame.smilegame.constant.database.ScoreDetailTableConstant.ADD_SCORE_DETAIL;
import static com.uob.smilegame.smilegame.constant.database.UserTableConstant.FIND_USER_BY_EMAIL;

@Repository
public class ScoreBoardRepositoryImpl implements ScoreBordRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScoreBoardRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ScoreBoardDto addScore(ScoreBoardDto scoreBoardDto){
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_EMAIL, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, scoreBoardDto.getEmail());
                return preparedStatement;
            }, keyHolder);

            int generatedKey = Objects.requireNonNull(keyHolder.getKey()).intValue();
            scoreBoardDto.setId(generatedKey);
            return scoreBoardDto;

        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public boolean updateScore(ScoreBoardDto scoreBoardDto) {
        try{
            return jdbcTemplate.update(ADD_USER_EMAIL,scoreBoardDto.getEmail(),scoreBoardDto.getId()) > 0;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public ScoreBoardDto findScoreBoardByEmail(String email) {
        try{
            return this.jdbcTemplate.queryForObject(FIND_USER_FROM_SCORE_TABLE,new Object[]{email},new ScoreBordRowMapper());
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public ScoreBoardDto findByEmailAndType(String email, String type) {
        try{
            return jdbcTemplate.queryForObject(FIND_SCORE_BY_EMAIL_AND_TYPE,new Object[]{type,email},new ScoreBoardDetailRowMapper());
        }catch (Exception e){
            return null;
        }
    }
}
