package com.revature.whoAmI.score;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score {

    @Id
    private String id;

    @Column(name="user_id")
    private String userId;

    @Column(name="time")
    private int time;

    public Score(){super();}

    public Score(String id, String userId, int time) {
        this.id = id;
        this.userId = userId;
        this.time = time;
    }

    public Score extractScore(Score score){
        this.id = score.getId();
        this.time = score.getTime();
        this.userId = score.getUserId();
        return this;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

}
