import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 1234;
    private static Registry registry;

    public static void main(String[] args) throws RemoteException, NotBoundException {
        System.out.println("This is client");
        registry = LocateRegistry.getRegistry(HOST, PORT);
        System.out.println("Got registry");
        LicenceService service = (LicenceService) registry.lookup(LicenceService.class.getSimpleName());

        User user = new User();
        LicenceData licence = service.getLicence(user);
        System.out.println(licence);
    }
}