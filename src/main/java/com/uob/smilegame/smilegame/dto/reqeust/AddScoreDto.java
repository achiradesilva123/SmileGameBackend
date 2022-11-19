package com.uob.smilegame.smilegame.dto.reqeust;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddScoreDto {

    private int id;
    private String email;
    private String type;
    private int score;

}
