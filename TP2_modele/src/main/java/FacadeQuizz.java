import exceptions.*;

import java.util.*;

public class FacadeQuizz implements IFacadeQuizz{
    private Map<String,Player> joueursInscrits;
    private Map<String,Question> questionsEnregis;
    private Map<String, Integer[]> repartitionReponses;


    public FacadeQuizz() {
        this.joueursInscrits = new HashMap<>();
        this.questionsEnregis = new HashMap<>() ;
        this.repartitionReponses = new HashMap<>();
    }

    @Override
    public void inscriptionPlayer(String pseudo) throws PseudoUtiliseException, DonneesIncompletesException {
        if (joueursInscrits.containsKey(pseudo)){
            throw new PseudoUtiliseException();
        }else {
            if(Objects.isNull(pseudo)||pseudo.isBlank()){
                throw new DonneesIncompletesException();
            }else {
                Player player = new Player(pseudo);
                this.joueursInscrits.put(pseudo,player);
            }

        }

    }

    @Override
    public void ajouterQuestion(String pseudo, String intitule, String[] propos) throws PseudoInexistantException{
        if(!joueursInscrits.containsKey(pseudo)){
            throw new PseudoInexistantException();
        }else{
            Question question= new Question(intitule,propos);
            this.questionsEnregis.put(question.getIdQuestion(),question);
        }

    }

    @Override
    public void repondreQuestion(String pseudo, String idQuestion, int reponse) throws PseudoInexistantException, QuestionInexistanteException, ReponseInexistanteException {
        if(!joueursInscrits.containsKey(pseudo)){
            throw new PseudoInexistantException();
        }else if(!questionsEnregis.containsKey(idQuestion)){
            throw new QuestionInexistanteException();
        }else if(reponse>4 || reponse <1){
            throw new ReponseInexistanteException();
        }else{
            joueursInscrits.get(pseudo).addReponse(idQuestion,reponse);
            if(repartitionReponses.containsKey(idQuestion)){
                repartitionReponses.get(idQuestion)[reponse-1]++;
            }else{
                Integer[] rep = new Integer[4];
                repartitionReponses.put(idQuestion,rep);
                repartitionReponses.get(idQuestion)[reponse-1]++;
            }
        }

    }

    @Override
    public Map<Question, Integer[]> consulterQuestion() {
        Map<Question, Integer[]> detailsQuestions = new HashMap<>();
        for(Map.Entry<String,Question> mp: questionsEnregis.entrySet()){
            detailsQuestions.put(mp.getValue(),repartitionReponses.get(mp.getKey()));
        }
        return detailsQuestions;
    }
}
