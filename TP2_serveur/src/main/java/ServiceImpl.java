
import DTO.QuestionDTO;
import exceptions.*;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceImpl extends UnicastRemoteObject implements Service{
    private IFacadeQuizz FacadeQuizz;

    public ServiceImpl(int port) throws RemoteException{
        super(port);
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
    public List<QuestionDTO> consulterQuestion() throws PasDeQuestionsException, RemoteException {
        List<QuestionDTO> questions =new ArrayList<>();

        for(Question q : this.FacadeQuizz.consulterQuestion()){
            questions.add(new QuestionDTO(q.getIntitule(),q.getPropReponse()));
        }

        return questions;


    }
}
