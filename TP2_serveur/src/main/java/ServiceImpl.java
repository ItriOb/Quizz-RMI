import DTO.QuestionDTO;
import exceptions.*;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class ServiceImpl extends UnicastRemoteObject implements Service, Serializable {
    private IFacadeQuizz FacadeQuizz;

    public ServiceImpl() throws RemoteException{
        this.FacadeQuizz = new FacadeQuizz();
    }


    @Override
    public void inscriptionPlayer(String pseudo) throws PseudoUtiliseException, DonneesIncompletesException, RemoteException {
        this.FacadeQuizz.inscriptionPlayer(pseudo);
    }

    @Override
    public void ajouterQuestion(String pseudo, String intitule, String[] propos) throws PseudoInexistantException, DonneesIncompletesException, RemoteException {
        this.FacadeQuizz.ajouterQuestion(pseudo,intitule,propos);
    }

    @Override
    public void repondreQuestion(String pseudo, String idQuestion, int reponse) throws PseudoInexistantException, QuestionInexistanteException, ReponseInexistanteException, QuestionDejaRepondue, DonneesIncompletesException, RemoteException {
        this.FacadeQuizz.repondreQuestion(pseudo, idQuestion, reponse);
    }

    @Override
    public Map<QuestionDTO, Integer[]> consulterQuestion() throws PasDeQuestionsException, RemoteException {
        this.FacadeQuizz.consulterQuestion();
        //you should retrun list of questions


    }
}
