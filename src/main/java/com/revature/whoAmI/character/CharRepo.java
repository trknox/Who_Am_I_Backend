package com.revature.whoAmI.character;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CharRepo extends CrudRepository<Character, String> {

    @Query(value="SELECT * FROM bible_characters WHERE id = ?1", nativeQuery = true)
    Character getCharById(String id);

    @Query(value="SELECT * FROM bible_characters", nativeQuery = true)
    ArrayList<Character> getAllCharacters();
}
