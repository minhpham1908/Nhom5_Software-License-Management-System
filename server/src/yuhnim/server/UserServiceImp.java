package yuhnim.server;

import yuhnim.rmi.model.User;
import yuhnim.rmi.service.UserService;
import yuhnim.server.DAL.UserDAO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserServiceImp extends UnicastRemoteObject implements UserService {
    private static final long serialVersionUID = 1L;

    protected UserServiceImp() throws RemoteException {
    }

    @Override
    public User getUser(String username) throws RemoteException {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.get(username);
        return user;
    }
}
