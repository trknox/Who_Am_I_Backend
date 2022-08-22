package com.revature.whoAmI.score;

import com.revature.whoAmI.score.dto.request.ScoreRequest;
import com.revature.whoAmI.score.dto.response.Principal;
import com.revature.whoAmI.user.User;
import com.revature.whoAmI.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ScoreService {

    @Inject
    private final ScoreRepo scoreRepo;

    @Inject
    @Autowired
    public ScoreService(ScoreRepo scoreRepo) {
        this.scoreRepo = scoreRepo;
    }

    public Score saveScore(ScoreRequest scoreRequest){
        Score score = scoreRequest.extractScore();

        scoreRepo.saveScore(score.getId(), score.getUserId(), score.getTime());

        return score;
    }

    public Score updateScore(ScoreRequest scoreRequest){
        Score score = scoreRequest.extractScore();

        scoreRepo.updateScore(score.getTime(), score.getUserId());

        return score;
    }

    public ArrayList<Score> getAllScores() { return scoreRepo.getAllScores(); }

    public List<Score> getAscScore(){
        return scoreRepo.getAscScore().stream().map(e -> new Score().extractScore(e)).collect(Collectors.toList());
    }

}
