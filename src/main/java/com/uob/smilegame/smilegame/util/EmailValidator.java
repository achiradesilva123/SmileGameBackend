package com.uob.smilegame.smilegame.util;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;
@Component
public class EmailValidator {

    public boolean isValidEmail(String email){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(email).matches();

    }

}
