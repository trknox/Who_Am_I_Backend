package com.revature.whoAmI.score;

import com.revature.whoAmI.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ScoreRepo extends CrudRepository<Score, String> {

    @Modifying
    @Query(value="INSERT into score(id, user_id, time) VALUES (?1, ?2, ?3)", nativeQuery = true)
    public void saveScore(String id, String userId, int time);

    @Modifying
    @Query(value="UPDATE score SET time = ?1 WHERE user_id = ?2", nativeQuery = true)
    public void updateScore(int time, String userId);

    @Query (value = "SELECT * FROM score", nativeQuery = true)
    ArrayList<Score> getAllScores();

    @Query(value = "SELECT * FROM score order by time ASC", nativeQuery = true)
    List<Score> getAscScore();
}
