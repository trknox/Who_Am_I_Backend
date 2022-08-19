package com.revature.whoAmI.hints;

import com.revature.whoAmI.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class HintsService {

    @Inject
    private final HintsRepo hintsRepo;

    @Inject
    @Autowired
    public HintsService(HintsRepo hintsRepo) {
        this.hintsRepo = hintsRepo;
    }

    public ArrayList<Hints> getHintsByCharId(String charId){
        return this.hintsRepo.getHintsByCharId(charId);
    }
}
