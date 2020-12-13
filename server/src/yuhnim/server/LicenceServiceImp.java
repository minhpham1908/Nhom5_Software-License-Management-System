package yuhnim.server;

import yuhnim.rmi.Licence;
import yuhnim.rmi.LicenceService;
import yuhnim.rmi.User;
import yuhnim.server.DAL.DAO;
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
        DAO licenceDAO = new LicenceDAO();
        ArrayList<Licence> licences = licenceDAO.getAll(user.getID());
        // Get products of that each licence
        return licences;
    }


}