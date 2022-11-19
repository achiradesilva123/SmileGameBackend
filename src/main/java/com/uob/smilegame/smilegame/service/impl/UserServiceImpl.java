package com.uob.smilegame.smilegame.service.impl;

import com.uob.smilegame.smilegame.dto.UserDto;
import com.uob.smilegame.smilegame.dto.response.FailedResponseDto;
import com.uob.smilegame.smilegame.dto.response.SuccessResponseDto;
import com.uob.smilegame.smilegame.repository.UserRepository;
import com.uob.smilegame.smilegame.service.UserService;
import com.uob.smilegame.smilegame.util.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private EmailValidator emailValidator;

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED , rollbackFor = Exception.class)
    public ResponseEntity saveUser(UserDto userDto) {
        try{

            if(!emailValidator.isValidEmail(userDto.getEmail()))
               return new ResponseEntity<>((new FailedResponseDto(false,"500","Invalid email")), HttpStatus.OK);

            UserDto userByEmail = userRepository.findUserByEmail(userDto.getEmail());

            if(!Objects.isNull(userByEmail))
                return new ResponseEntity<>((new SuccessResponseDto(200,userByEmail,true)), HttpStatus.OK);

            UserDto user = userRepository.saveUser(userDto);
               return new ResponseEntity<>((new SuccessResponseDto(200,user,true)), HttpStatus.OK);

        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public ResponseEntity updateUser(UserDto userDto) {
        if(userDto.getUserId() == 0)
            return new ResponseEntity<>((new FailedResponseDto(false,"500","Empty required fields try again !")), HttpStatus.OK);

        if(!emailValidator.isValidEmail(userDto.getEmail()))
            return new ResponseEntity<>((new FailedResponseDto(false,"500","Invalid email")), HttpStatus.OK);

        if(userRepository.updateUser(userDto))
            return new ResponseEntity<>((new SuccessResponseDto(200,userDto,true)), HttpStatus.OK);

        return new ResponseEntity<>((new FailedResponseDto(false,"500","failed to update user")),HttpStatus.OK);

    }
}
