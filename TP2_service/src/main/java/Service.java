import DTO.QuestionDTO;
import exceptions.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface Service  extends Remote {
    public void inscriptionPlayer(String pseudo) throws PseudoUtiliseException, DonneesIncompletesException, RemoteException;
    public void ajouterQuestion(String pseudo, String intitule, String[] propos) throws PseudoInexistantException,DonneesIncompletesException,RemoteException;
    public void repondreQuestion(String pseudo, String idQuestion, int reponse)throws PseudoInexistantException, QuestionInexistanteException, ReponseInexistanteException, QuestionDejaRepondue, DonneesIncompletesException,RemoteException;
    public List<QuestionDTO> consulterQuestion() throws PasDeQuestionsException,RemoteException;
}
