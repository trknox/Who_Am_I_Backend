package com.revature.whoAmI.hints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hints")
public class Hints {
    @Id
    private String id;

    @Column
    private String characterId;

    @Column
    private String hint;

    @Column
    private String scripture;

    public Hints(){
        super();
    }

    public Hints(String id, String characterId, String hint, String scripture) {
        this.id = id;
        this.characterId = characterId;
        this.hint = hint;
        this.scripture = scripture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getScripture() {
        return scripture;
    }

    public void setScripture(String scripture) {
        this.scripture = scripture;
    }
}
