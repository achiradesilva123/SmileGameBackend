package com.uob.smilegame.smilegame.repository.impl;

import com.uob.smilegame.smilegame.constant.database.ScoreDetailTableConstant;
import com.uob.smilegame.smilegame.dto.ScoreBoardDetailDto;
import com.uob.smilegame.smilegame.repository.ScoreBoardDetailRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;

import static com.uob.smilegame.smilegame.constant.database.ScoreDetailTableConstant.ADD_SCORE_DETAIL;
import static com.uob.smilegame.smilegame.constant.database.ScoreDetailTableConstant.UPDATE_SCORE_DETAIL;

@Repository
@Transactional
public class ScoreBoardDetailRepositoryImpl implements ScoreBoardDetailRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScoreBoardDetailRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ScoreBoardDetailDto addScoreDetail(ScoreBoardDetailDto detailDto) {

        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement preparedStatement = connection.prepareStatement(ADD_SCORE_DETAIL, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, detailDto.getScId());
                preparedStatement.setObject(2, detailDto.getType());
                preparedStatement.setObject(3, detailDto.getScore());
                return preparedStatement;
            }, keyHolder);

            int generatedKey = Objects.requireNonNull(keyHolder.getKey()).intValue();
            detailDto.setId(generatedKey);
            return detailDto;

        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public boolean updateScoreDetail(ScoreBoardDetailDto detailDto) {
        try{
            return jdbcTemplate.update(UPDATE_SCORE_DETAIL,detailDto.getType(),detailDto.getScore(),detailDto.getScId()) > 0;
        }catch (Exception e){
            throw e;
        }
    }


}
