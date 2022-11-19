package com.uob.smilegame.smilegame.repository;

import com.uob.smilegame.smilegame.dto.ScoreBoardDto;

public interface ScoreBordRepository {

    ScoreBoardDto addScore(ScoreBoardDto scoreBoardDto);

    boolean updateScore(ScoreBoardDto scoreBoardDto);

    ScoreBoardDto findScoreBoardByEmail(String email);


    ScoreBoardDto findByEmailAndType(String email,String type);


}
