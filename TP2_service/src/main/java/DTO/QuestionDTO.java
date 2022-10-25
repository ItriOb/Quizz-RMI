package DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class QuestionDTO implements Serializable {
    private String intitule;
    private String[] propReponse;
    private String idQuestion;

    public QuestionDTO(String intitule, String[] propReponse) {
        this.intitule = intitule;
        this.propReponse = propReponse;
        this.idQuestion = UUID.randomUUID().toString();
    }

    public String getIntitule() {
        return this.intitule;
    }

    public String[] getPropReponse() {
        return this.propReponse;
    }

    public String getIdQuestion() {
        return this.idQuestion;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setPropReponse(String[] propReponse) {
        this.propReponse = propReponse;
    }
}
