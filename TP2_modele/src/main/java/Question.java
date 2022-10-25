import java.util.UUID;

public class Question {
    private String intitule;
    private String[] propReponse;
    private String idQuestion;

    public Question(String intitule, String[] propReponse) {
        this.intitule = intitule;
        this.propReponse = propReponse;
        this.idQuestion= UUID.randomUUID().toString();
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

}
