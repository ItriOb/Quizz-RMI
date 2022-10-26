import java.util.UUID;

public class Question {
    private String intitule;
    private String[] propReponse;
    private String idQuestion;
    private Integer[] reparResponse;

    public Question(String intitule, String[] propReponse) {
        this.intitule = intitule;
        this.propReponse = propReponse;
        this.idQuestion= UUID.randomUUID().toString();
        this.reparResponse=new Integer[4];
    }

    public String getIntitule() {
        return intitule;
    }

    public String[] getPropReponse() {
        return propReponse;
    }

    public String getIdQuestion() {
        return idQuestion;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setPropReponse(String[] propReponse) {
        this.propReponse = propReponse;
    }

    public Integer[] getReparResponse() {
        return reparResponse;
    }

    public void reponse(int reponse){
        reparResponse[reponse-1]++;
    }

}
