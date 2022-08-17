package com.revature.whoAmI.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepo extends CrudRepository<User, String> {
    @Query(value = "SELECT * FROM users WHERE id = ?1", nativeQuery = true)
    User getUserByID(String id);
    @Query (value = "SELECT * FROM users WHERE username = ?1", nativeQuery = true)
    User getUserByUsername(String username);
    @Query (value = "SELECT * FROM users WHERE username = ?1 AND password = crypt(?2, password)", nativeQuery = true)
    User getUserByUsernameAndPassword(String username, String password);
    @Query (value = "SELECT * FROM users", nativeQuery = true)
    ArrayList<User> getAllUsers();

    //</editor-fold desc="Query>

    //<editor-fold desc="Save">
    @Modifying
    @Query (value = "INSERT INTO users (id, first_name, last_name, username, password) VALUES (?1, ?2, crypt(?3, gen_salt('bf')), ?4, ?5)", nativeQuery = true)
    public void saveUser(String id, String firstName, String lastName, String username, String password);
    //</editor-fold desc="Save">

}
