package com.revature.whoAmI.character;

import com.revature.whoAmI.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class CharService {

    @Inject
    private final CharRepo charRepo;

    @Inject
    @Autowired
    public CharService(CharRepo charRepo) {
        this.charRepo = charRepo;
    }

    public Character getCharById(String id){
        return this.charRepo.getCharById(id);
    }

    public ArrayList<Character> getAllCharacters(){ return this.charRepo.getAllCharacters(); }
}
