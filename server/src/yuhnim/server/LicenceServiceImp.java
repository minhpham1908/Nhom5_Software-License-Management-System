package yuhnim.server;

import yuhnim.rmi.Licence;
import yuhnim.rmi.LicenceService;
import yuhnim.rmi.User;
import yuhnim.server.DAL.LicenceDAO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * yuhnim.server.LicenceServiceImp
 */
public class LicenceServiceImp extends UnicastRemoteObject implements LicenceService {
    private static final long serialVersionUID = 1L;


    public LicenceServiceImp() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Licence> getLicences(User user) {
        LicenceDAO licenceDAO = null;
        ArrayList<Licence> licences = licenceDAO.getAll(user.getID());
        return licences;
    }


}