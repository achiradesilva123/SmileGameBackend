package com.uob.smilegame.smilegame.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScoreBoardDetailDto {

    private int id;
    private int scId;
    private String type;
    private int score;

    public ScoreBoardDetailDto(int scId, String type, int score) {
        this.scId = scId;
        this.type = type;
        this.score = score;
    }
}
