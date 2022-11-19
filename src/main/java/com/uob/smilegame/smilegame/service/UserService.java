package com.uob.smilegame.smilegame.service;

import com.uob.smilegame.smilegame.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity saveUser(UserDto userDto);

    ResponseEntity updateUser(UserDto userDto);

}
