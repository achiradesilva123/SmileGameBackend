package com.uob.smilegame.smilegame.controller;

import com.uob.smilegame.smilegame.dto.ScoreBoardDto;
import com.uob.smilegame.smilegame.dto.reqeust.AddScoreDto;
import com.uob.smilegame.smilegame.service.ScoreBoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/score")
public class ScoreBoardController {

    private final ScoreBoardService scoreBoardService;

    public ScoreBoardController(ScoreBoardService scoreBoardService) {
        this.scoreBoardService = scoreBoardService;
    }

    @PostMapping
    ResponseEntity addScore(@RequestBody AddScoreDto scoreBoardDto){
        return  scoreBoardService.addScore(scoreBoardDto);
    }

}
