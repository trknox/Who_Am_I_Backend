package com.revature.whoAmI.score;

import com.revature.whoAmI.score.dto.request.ScoreRequest;
import com.revature.whoAmI.user.User;
import com.revature.whoAmI.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Inject
    private ScoreService scoreService;

    @Inject
    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/new-score", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveScore(@RequestBody ScoreRequest scoreRequest){
        scoreService.saveScore(scoreRequest);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value="update-score", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateScore(@RequestBody ScoreRequest scoreRequest) { scoreService.updateScore(scoreRequest);}

    @CrossOrigin
    @GetMapping(value = "/all-scores")
    public @ResponseBody ArrayList<Score> getAllScores(){
        return scoreService.getAllScores();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @CrossOrigin
    @GetMapping(path = "/asc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Score> getAscScore(){
        return scoreService.getAscScore();
    }

}
