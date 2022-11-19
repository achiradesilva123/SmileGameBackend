package com.uob.smilegame.smilegame.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private int userId;
    private String name;
    private String email;
    private String dob;


}
