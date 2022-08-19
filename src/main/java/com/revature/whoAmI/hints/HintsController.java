package com.revature.whoAmI.hints;

import com.revature.whoAmI.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/hints")
public class HintsController {

    @Inject
    private final HintsService hintsService;

    @Inject
    @Autowired
    public HintsController(HintsService hintsService) {
        this.hintsService = hintsService;
    }

    @CrossOrigin
    @GetMapping(value = "/char-id/{charId}")
    public @ResponseBody ArrayList<Hints> getHintByCharId(@PathVariable String charId){
        return hintsService.getHintsByCharId(charId);
    }
}
