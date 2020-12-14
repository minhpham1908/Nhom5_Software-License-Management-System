package yuhnim.server;

import yuhnim.rmi.AuthorizationService;
import yuhnim.rmi.User;
import yuhnim.rmi.UserService;

import java.rmi.RemoteException;

public class UserServiceImp implements UserService {

    @Override
    public User getUser(String username) throws RemoteException {
        return null;
    }
}
