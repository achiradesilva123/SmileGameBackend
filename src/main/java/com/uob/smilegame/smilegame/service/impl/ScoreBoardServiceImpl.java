package com.uob.smilegame.smilegame.service.impl;

import com.uob.smilegame.smilegame.dto.ScoreBoardDetailDto;
import com.uob.smilegame.smilegame.dto.ScoreBoardDto;
import com.uob.smilegame.smilegame.dto.reqeust.AddScoreDto;
import com.uob.smilegame.smilegame.dto.response.FailedResponseDto;
import com.uob.smilegame.smilegame.dto.response.ScoreBoardResponseDto;
import com.uob.smilegame.smilegame.dto.response.SuccessResponseDto;
import com.uob.smilegame.smilegame.repository.ScoreBoardDetailRepository;
import com.uob.smilegame.smilegame.repository.ScoreBordRepository;
import com.uob.smilegame.smilegame.service.ScoreBoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ScoreBoardServiceImpl implements ScoreBoardService {

    private final ScoreBordRepository scoreBordRepository;
    private final ScoreBoardDetailRepository scoreBoardDetailRepository;

    public ScoreBoardServiceImpl(ScoreBordRepository scoreBordRepository, ScoreBoardDetailRepository scoreBoardDetailRepository) {
        this.scoreBordRepository = scoreBordRepository;
        this.scoreBoardDetailRepository = scoreBoardDetailRepository;
    }

    @Override
    public ResponseEntity addScore(AddScoreDto scoreDto) {
        try{

            System.out.println("add -"+  scoreDto.getEmail());

            if(Objects.isNull(scoreDto))
                return new ResponseEntity<>((new FailedResponseDto(false,"500","Empty required fields try again !")), HttpStatus.OK);


            ScoreBoardDto scoreBoardByEmail = scoreBordRepository.findScoreBoardByEmail(scoreDto.getEmail());

            if(Objects.isNull(scoreBoardByEmail)){

                System.out.println("if -1");
                ScoreBoardDto scoreBoardDto = scoreBordRepository.addScore(new ScoreBoardDto(scoreDto.getEmail()));
                if(scoreBoardDto == null)
                    return new ResponseEntity<>((new FailedResponseDto(false,"500","Something went wrong !")), HttpStatus.OK);

                ScoreBoardDetailDto scoreBoardDetailDto = scoreBoardDetailRepository.addScoreDetail(new ScoreBoardDetailDto(scoreBoardDto.getId(), scoreDto.getType(), scoreDto.getScore()));

                return new ResponseEntity<>((new SuccessResponseDto(200,"Score added successfully",true)), HttpStatus.OK);

            }


            System.out.println("came out side if-1");

            ScoreBoardDto emailAndType = scoreBordRepository.findByEmailAndType(scoreDto.getEmail(), scoreDto.getType());

            if(Objects.isNull(emailAndType)) {
                System.out.println("if-2");
                scoreBoardDetailRepository.addScoreDetail(new ScoreBoardDetailDto(scoreBoardByEmail.getId(), scoreDto.getType(), scoreDto.getScore()));
                return new ResponseEntity<>((new SuccessResponseDto(200,"Score added successfully",true)), HttpStatus.OK);
            }

            System.out.println("came out side if-2");

            if(emailAndType.getScoreBoardDetailDto().getScore() < scoreDto.getScore())
              if(scoreBoardDetailRepository.updateScoreDetail(new ScoreBoardDetailDto(emailAndType.getId(),scoreDto.getType(), scoreDto.getScore())))
                return new ResponseEntity<>((new SuccessResponseDto(200,"Score added successfully",true)), HttpStatus.OK);



            return new ResponseEntity<>((new FailedResponseDto(false,"500","failed to save score")),HttpStatus.OK);


        }catch (Exception e){
            throw e;
        }
    }
}
