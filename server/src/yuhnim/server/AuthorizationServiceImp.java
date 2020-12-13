package yuhnim.server;

import yuhnim.rmi.AuthorizationService;
import yuhnim.rmi.User;

import java.rmi.RemoteException;

public class AuthorizationServiceImp implements AuthorizationService {
    @Override
    public boolean authorize(User user) throws RemoteException {
        return false;
    }
}
