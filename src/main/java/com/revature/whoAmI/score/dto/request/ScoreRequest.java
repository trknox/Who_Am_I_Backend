package com.revature.whoAmI.score.dto.request;

import com.revature.whoAmI.score.Score;
import com.revature.whoAmI.user.User;

import java.util.UUID;

public class ScoreRequest {

    private String userId;

    private int time;

    public ScoreRequest() {
        super();
    }

    public ScoreRequest(String userId, int time) {
        this.userId = userId;
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Score extractScore(){
        Score score = new Score();
        score.setId(UUID.randomUUID().toString());
        score.setTime(getTime());
        score.setUserId(getUserId());
        return score;
    }
}
