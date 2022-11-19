package com.uob.smilegame.smilegame.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScoreBoardDto {

    private int id;
    private String email;

    private ScoreBoardDetailDto scoreBoardDetailDto;

    public ScoreBoardDto(String email) {
        this.email = email;
    }

}
