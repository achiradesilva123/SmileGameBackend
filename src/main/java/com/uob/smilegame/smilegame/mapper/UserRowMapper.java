package com.uob.smilegame.smilegame.mapper;

import com.uob.smilegame.smilegame.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserDto> {

    @Override
    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {

        UserDto userDto = new UserDto();
        userDto.setUserId(rs.getInt("userId"));
        userDto.setEmail(rs.getString("email"));
        userDto.setName(rs.getString("name"));
        userDto.setDob(rs.getString("dob"));

        return userDto;
    }
}
