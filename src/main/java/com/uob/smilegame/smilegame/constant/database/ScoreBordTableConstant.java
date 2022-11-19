package com.uob.smilegame.smilegame.constant.database;

public class ScoreBordTableConstant {

    public static final String ADD_USER_EMAIL = "insert into scoreboard (email) values(?)";

    public static final String FIND_USER_FROM_SCORE_TABLE = "select * from scoreboard where email =?";

    public static final String FIND_SCORE_BY_EMAIL_AND_TYPE = "SELECT sc.id,sc.email,s.id as detailId,s.scid,s.type,s.score FROM scoreboard sc,scoredetail s where sc.id in (select scid from scoredetail  where type = ?) and email = ?";

}
