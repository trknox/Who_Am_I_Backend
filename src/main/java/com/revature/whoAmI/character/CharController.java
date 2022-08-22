package com.revature.whoAmI.character;

import com.revature.whoAmI.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/character")
public class CharController {

    @Inject
    private final CharService charService;

    @Inject
    @Autowired

    public CharController(CharService charService) {
        this.charService = charService;
    }

    @CrossOrigin
    @GetMapping(value = "/id/{id}")
    public @ResponseBody Character getCharById(@PathVariable String id){
        return charService.getCharById(id);
    }

    @CrossOrigin
    @GetMapping(value = "/all-characters")
    public @ResponseBody ArrayList<Character> getAllCharacters(){
        return charService.getAllCharacters();
    }


}
