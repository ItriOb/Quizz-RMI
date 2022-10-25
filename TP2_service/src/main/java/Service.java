import DTO.QuestionDTO;
import exceptions.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface Service  extends Remote {
    public void inscriptionPlayer(String pseudo) throws PseudoUtiliseException, DonneesIncompletesException, RemoteException;
    public void ajouterQuestion(String pseudo, String intitule, String[] propos) throws PseudoInexistantException,RemoteException;
    public void repondreQuestion(String pseudo, String idQuestion, int reponse)throws PseudoInexistantException, QuestionInexistanteException, ReponseInexistanteException,RemoteException;
    public Map<QuestionDTO, Integer[]> consulterQuestion() throws PasDeQuestionsException,RemoteException;
}
