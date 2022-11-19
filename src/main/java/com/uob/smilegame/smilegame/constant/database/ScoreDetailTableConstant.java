package com.uob.smilegame.smilegame.constant.database;

public class ScoreDetailTableConstant {

    public static final String ADD_SCORE_DETAIL = "insert into scoredetail (scId,type,score) values(?,?,?)";
    public static final String UPDATE_SCORE_DETAIL = "update scoredetail set type = ? ,score = ? where scId =?";


}
