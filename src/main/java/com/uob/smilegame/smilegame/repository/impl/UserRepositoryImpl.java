package com.uob.smilegame.smilegame.repository.impl;

import com.uob.smilegame.smilegame.constant.database.UserTableConstant;
import com.uob.smilegame.smilegame.dto.UserDto;
import com.uob.smilegame.smilegame.mapper.UserRowMapper;
import com.uob.smilegame.smilegame.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;

import static com.uob.smilegame.smilegame.constant.database.UserTableConstant.*;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, userDto.getName());
                preparedStatement.setObject(2, userDto.getEmail());
                preparedStatement.setObject(3, userDto.getDob());
                return preparedStatement;
            }, keyHolder);

            int generatedKey = Objects.requireNonNull(keyHolder.getKey()).intValue();
            userDto.setUserId(generatedKey);
            return userDto;

        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public UserDto findUserByEmail(String email) {
        try{
            return this.jdbcTemplate.queryForObject(FIND_USER_BY_EMAIL,new Object[]{email},new UserRowMapper());
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        try{
            return jdbcTemplate.update(UPDATE_USER,userDto.getName(),userDto.getDob(),userDto.getEmail(),userDto.getUserId() ) > 0;
        }catch (Exception e){
            throw e;
        }
    }
}
