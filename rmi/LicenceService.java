import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * LicenceService
 */
public interface LicenceService extends Remote {
    public LicenceData getLicence(User user) throws RemoteException;
}