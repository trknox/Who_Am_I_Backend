package com.revature.whoAmI.score.dto.response;

import com.revature.whoAmI.score.Score;
import com.revature.whoAmI.user.User;

import java.sql.Date;

public class Principal {
    private String id;
    private int time;

    public Principal() {
        super();
    }

    public Principal(Score score) {
        this.id = score.getId();
        this.time = score.getTime();
    }

    public Principal(String id, int time) {
        this.id = id;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
