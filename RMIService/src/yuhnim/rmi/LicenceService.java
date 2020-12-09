package yuhnim.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * yuhnim.rmi.LicenceService
 */
public interface LicenceService extends Remote {
    public Licence getLicence(User user) throws RemoteException;
}