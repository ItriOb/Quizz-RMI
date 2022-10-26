import exceptions.*;

import java.util.*;

public class FacadeQuizz implements IFacadeQuizz {
    private Map<String, Player> joueursInscrits;
    private Map<String, Question> questionsEnregis;


    public FacadeQuizz() {
        this.joueursInscrits = new HashMap<>();
        this.questionsEnregis = new HashMap<>();
    }

    @Override
    public void inscriptionPlayer(String pseudo) throws PseudoUtiliseException, DonneesIncompletesException {
        if (Objects.isNull(pseudo) || pseudo.isBlank()) {
            throw new DonneesIncompletesException();
        } else if (joueursInscrits.containsKey(pseudo)) {
            throw new PseudoUtiliseException();
        } else {
            Player player = new Player(pseudo);
            this.joueursInscrits.put(pseudo, player);
        }

    }

    @Override
    public void ajouterQuestion(String pseudo, String intitule, String[] propos) throws PseudoInexistantException, DonneesIncompletesException {
        if (Objects.isNull(intitule) || intitule.isBlank() || Objects.isNull(propos) || propos.length != 4) {
            throw new DonneesIncompletesException();
        } else if (!joueursInscrits.containsKey(pseudo)) {
            throw new PseudoInexistantException();
        } else {
            Question question = new Question(intitule, propos);
            this.questionsEnregis.put(question.getIdQuestion(), question);
        }

    }

    @Override
    public void repondreQuestion(String pseudo, String idQuestion, int reponse) throws PseudoInexistantException, QuestionInexistanteException, ReponseInexistanteException, QuestionDejaRepondue, DonneesIncompletesException {
        if (Objects.isNull(idQuestion) || idQuestion.isBlank() || (Integer)reponse==null) {
            throw new DonneesIncompletesException();
        }else if (reponse > 4 || reponse < 1) {
            throw new ReponseInexistanteException();
        }if (!joueursInscrits.containsKey(pseudo)) {
            throw new PseudoInexistantException();
        } else if (!questionsEnregis.containsKey(idQuestion)) {
            throw new QuestionInexistanteException();
        }else if(joueursInscrits.get(pseudo).isAnswered(idQuestion)){
            throw new QuestionDejaRepondue();
        } else {
            questionsEnregis.get(idQuestion).reponse(reponse);
            joueursInscrits.get(pseudo).addReponse(idQuestion,reponse);
        }

    }

    @Override
    public Map<Question, Integer[]> consulterQuestion() throws PasDeQuestionsException {
        if (questionsEnregis.isEmpty()) {
            throw new PasDeQuestionsException();
        } else {
            Map<Question, Integer[]> detailsQuestions = new HashMap<>();
            for (Map.Entry<String, Question> mp : questionsEnregis.entrySet()) {
                detailsQuestions.put(mp.getValue(), mp.getValue().getReparResponse());
            }
            return detailsQuestions;
        }

    }
}
