package yuhnim.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * yuhnim.rmi.LicenceService
 */
public interface LicenceService extends Remote {
    public LicenceData getLicence(User user) throws RemoteException;
}