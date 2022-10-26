import java.util.HashMap;
import java.util.Map;

public class Player {
    private String pseudo;
    Map<String, Integer> reponses;

    public Player(String pseudo) {

        this.pseudo = pseudo ;
        this.reponses=new HashMap<>();
    }

    public String getPseudo() {
        return pseudo;
    }

    public void addReponse(String idQuestion , int reponse) {
        reponses.put(idQuestion,reponse);
    }

    public boolean isAnswered(String idQuestion){
        if(reponses.containsKey(idQuestion)){
            return true;
        }else return false;
    }
}
