package yuhnim.rmi.service;

import yuhnim.rmi.model.Licence;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * yuhnim.rmi.service.LicenceService
 */
public interface LicenceService extends Remote {
    ArrayList<Licence> getLicences(Integer userId) throws RemoteException;
}