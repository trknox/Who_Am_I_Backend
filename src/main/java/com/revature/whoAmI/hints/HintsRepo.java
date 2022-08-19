package com.revature.whoAmI.hints;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HintsRepo extends CrudRepository<Hints, String> {

    @Query(value="SELECT * FROM hints WHERE character_id = ?1", nativeQuery = true)
    ArrayList<Hints> getHintsByCharId(String charId);
}
