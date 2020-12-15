package yuhnim.server;

import yuhnim.rmi.Licence;
import yuhnim.rmi.LicenceService;
import yuhnim.rmi.Product;
import yuhnim.rmi.User;
import yuhnim.server.DAL.DAO;
import yuhnim.server.DAL.LicenceDAO;
import yuhnim.server.DAL.ProductDAO;

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
    }

    @Override
    public ArrayList<Licence> getLicences(Integer userId) {
        DAO licenceDAO = new LicenceDAO();
        ArrayList<Licence> licences = licenceDAO.getAll(userId);
        // Get products of that each licence
        DAO producDao = new ProductDAO();
        for (Licence licence : licences) {
            ArrayList<Product> products = producDao.getAll(licence.getLicenceID());
            licence.setProductName(products);
        }
        return licences;
    }
}