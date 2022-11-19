package com.uob.smilegame.smilegame.repository;

import com.uob.smilegame.smilegame.dto.ScoreBoardDetailDto;

public interface ScoreBoardDetailRepository {

    ScoreBoardDetailDto addScoreDetail(ScoreBoardDetailDto detailDto);

    boolean updateScoreDetail(ScoreBoardDetailDto detailDto);

}
