package yuhnim.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AuthorizationService extends Remote {
    public boolean authorize(User user) throws RemoteException;
}
