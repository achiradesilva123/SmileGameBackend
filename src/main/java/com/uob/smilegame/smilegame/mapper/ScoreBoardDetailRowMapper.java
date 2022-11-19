package com.uob.smilegame.smilegame.mapper;


import com.uob.smilegame.smilegame.dto.ScoreBoardDetailDto;
import com.uob.smilegame.smilegame.dto.ScoreBoardDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreBoardDetailRowMapper implements RowMapper<ScoreBoardDto> {
    @Override
    public ScoreBoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {

        ScoreBoardDto scoreBoardDto = new ScoreBoardDto();
        scoreBoardDto.setId(rs.getInt("id"));
        scoreBoardDto.setEmail(rs.getString("email"));
        scoreBoardDto.setScoreBoardDetailDto(new ScoreBoardDetailDto(rs.getInt("detailId"),rs.getInt("scid"),rs.getString("type"),rs.getInt("score")));

        return scoreBoardDto;
    }
}
