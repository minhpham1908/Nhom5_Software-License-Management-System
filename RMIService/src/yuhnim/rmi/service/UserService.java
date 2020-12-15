package yuhnim.rmi.service;

import yuhnim.rmi.model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {
    User getUser(String username) throws RemoteException;
}
