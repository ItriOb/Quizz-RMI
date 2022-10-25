import exceptions.*;

import java.util.Map;

public interface IFacadeQuizz {
    public void inscriptionPlayer(String pseudo) throws PseudoUtiliseException, DonneesIncompletesException;
    public void ajouterQuestion(String pseudo, String intitule, String[] propos) throws PseudoInexistantException;
    public void repondreQuestion(String pseudo, String idQuestion, int reponse)throws PseudoInexistantException, QuestionInexistanteException, ReponseInexistanteException;
    public Map<Question, Integer[]> consulterQuestion();

}
