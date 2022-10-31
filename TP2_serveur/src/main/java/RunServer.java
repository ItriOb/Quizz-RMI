import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RunServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        LocateRegistry.createRegistry(3131);
        Naming.bind("rmi://localhost:3131/quizzonline", new ServiceImpl(3131));
        System.out.println("Server started !!");
    }

}
