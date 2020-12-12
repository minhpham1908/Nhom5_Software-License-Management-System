package yuhnim.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * yuhnim.rmi.LicenceService
 */
public interface LicenceService extends Remote {
    public ArrayList<Licence> getLicences(User user) throws RemoteException;
}