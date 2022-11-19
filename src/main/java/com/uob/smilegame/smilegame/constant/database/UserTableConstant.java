package com.uob.smilegame.smilegame.constant.database;

public class UserTableConstant {

    public static final String SAVE_USER = "insert into user (name,email,dob) values(?,?,?)";
    public static final String FIND_USER_BY_EMAIL = "select * from user where email =?";
    public static final String UPDATE_USER = "update user set name = ?, dob =?,email=? where userId =?";



}
