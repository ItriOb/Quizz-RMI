import exceptions.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Program {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException, DonneesIncompletesException, PasDeQuestionsException, PseudoDejaExistantException, PseudoInexistantException, QuestionDejaRepondue, QuestionInexistanteException, ReponseInexistanteException, PseudoUtiliseException {
        Service service =(Service) Naming.lookup("rmi://localhost:3131/quizzonline");

        service.inscriptionPlayer("Itri");
        String[] prop = {"JAVA","SQL","JS","PHP"};
        service.ajouterQuestion("Itri","Qu'elle est le meilleur langage ?",prop);



    }
}
