package com.uob.smilegame.smilegame.controller;

import com.uob.smilegame.smilegame.dto.UserDto;
import com.uob.smilegame.smilegame.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserDto userDto){
       return userService.saveUser(userDto);
    };

    @PutMapping
    public ResponseEntity updateUser(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

}
