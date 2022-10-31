import exceptions.*;

import java.util.List;
import java.util.Map;

public interface IFacadeQuizz {
    public void inscriptionPlayer(String pseudo) throws PseudoUtiliseException, DonneesIncompletesException;
    public void ajouterQuestion(String pseudo, String intitule, String[] propos) throws PseudoInexistantException, DonneesIncompletesException;
    public void repondreQuestion(String pseudo, String idQuestion, int reponse)throws PseudoInexistantException, QuestionInexistanteException, ReponseInexistanteException, QuestionDejaRepondue, DonneesIncompletesException;
    public List<Question> consulterQuestion() throws PasDeQuestionsException;


}
