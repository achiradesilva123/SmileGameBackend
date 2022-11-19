package com.uob.smilegame.smilegame.repository;

import com.uob.smilegame.smilegame.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;


public interface UserRepository {

    UserDto saveUser(UserDto userDto);

    UserDto findUserByEmail(String email);

    boolean updateUser(UserDto userDto);


}
