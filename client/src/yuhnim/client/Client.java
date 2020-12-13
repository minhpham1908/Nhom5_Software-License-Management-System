package yuhnim.client;

import yuhnim.rmi.Licence;
import yuhnim.rmi.LicenceService;
import yuhnim.rmi.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 1234;
    private static Registry registry;

    public Client() throws RemoteException, NotBoundException {
        registry = LocateRegistry.getRegistry(HOST, PORT);
        System.out.println("Got registry");
    }

    public List<Licence> getLicences() throws RemoteException, NotBoundException {
        LicenceService service = (LicenceService) registry.lookup(LicenceService.class.getSimpleName());
        System.out.println("get service success");
        User user = new User(0);
        List<Licence> licences = service.getLicences(user);
        return licences;
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        System.out.println("This is client");
        Client client =new Client();
        System.out.println(client.getLicences());

    }
}