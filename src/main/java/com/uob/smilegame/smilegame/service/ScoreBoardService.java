package com.uob.smilegame.smilegame.service;

import com.uob.smilegame.smilegame.dto.ScoreBoardDto;
import com.uob.smilegame.smilegame.dto.reqeust.AddScoreDto;
import org.springframework.http.ResponseEntity;

public interface ScoreBoardService {

    ResponseEntity addScore(AddScoreDto scoreDto);

}
