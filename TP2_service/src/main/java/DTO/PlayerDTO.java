package DTO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PlayerDTO implements Serializable {
    private String pseudo;
    Map<String, Integer> reponses;

    public PlayerDTO(String pseudo) {
        this.pseudo = pseudo;
        this.reponses = new HashMap();
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public Map<String, Integer> getReponses() {
        return this.reponses;
    }
}
