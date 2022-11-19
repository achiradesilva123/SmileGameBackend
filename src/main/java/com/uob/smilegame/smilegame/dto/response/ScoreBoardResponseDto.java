package com.uob.smilegame.smilegame.dto.response;

import com.uob.smilegame.smilegame.dto.ScoreBoardDetailDto;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreBoardResponseDto {

    private int id;
    private String email;
    private ScoreBoardDetailDto scoreBoardDetailDto;

}
