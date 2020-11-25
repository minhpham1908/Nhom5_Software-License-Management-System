import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject {
    private static final long serialVersionUID = 1L;
    private static final int PORT = 1234;
    public static Registry registry;

    protected Server() throws RemoteException, AlreadyBoundException {
        startRegistry();
        registerService(LicenceService.class.getSimpleName(), new LicenceServiceImp());
    }

    public static void startRegistry() throws RemoteException {
        registry = LocateRegistry.createRegistry(PORT);
    }

    public static void registerService(String name, Remote service)
            throws AccessException, RemoteException, AlreadyBoundException {
        registry.bind(name, service);
        System.out.println("Registered: " + name + " -> " + service.getClass().getName() + "[" + service + "]");
    }

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        System.out.println("SERVER STARTING...");
        new Server();
        System.out.println("Server is running");
    }
}
