package yuhnim.client;

import yuhnim.rmi.model.Licence;
import yuhnim.rmi.service.LicenceService;
import yuhnim.rmi.model.User;
import yuhnim.rmi.service.UserService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client {
    private static final String HOST = "running-server";
    private static final int PORT = 1234;
    private static Registry registry;
    private User user;

    public Client() throws RemoteException, NotBoundException {
        registry = LocateRegistry.getRegistry(HOST, PORT);
        System.out.println("Got registry");
    }

    public List<Licence> getLicences(Integer userId) throws RemoteException, NotBoundException {
        LicenceService service = (LicenceService) registry.lookup(LicenceService.class.getSimpleName());
        System.out.println("Got service successfully");
        User user = new User(userId);
        List<Licence> licences = service.getLicences(userId);
        return licences;
    }

    public User getUserByUsername(String username) throws RemoteException, NotBoundException {
        UserService userService = (UserService) registry.lookup(UserService.class.getSimpleName());
        System.out.println("G0t userService succesfully!");
        User user = userService.getUser(username);
        return user;
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        System.out.println("This is client");
        Client client =new Client();
        System.out.println(client.getLicences(2));

    }
}