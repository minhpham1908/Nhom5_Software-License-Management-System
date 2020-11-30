package yuhnim.server;

import yuhnim.rmi.LicenceData;
import yuhnim.rmi.LicenceService;
import yuhnim.rmi.User;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

/**
 * yuhnim.server.LicenceServiceImp
 */
public class LicenceServiceImp extends UnicastRemoteObject implements LicenceService {
    private static final long serialVersionUID = 1L;

    public LicenceServiceImp() throws RemoteException {
        super();
    }
    
    @Override
    public LicenceData getLicence(User user) {
        Date now =  new Date();
        ArrayList<String> products = new ArrayList<String>();
        products.add("some product");
        LicenceData licenceData = new LicenceData("1234AD",now , products);
        return licenceData;
    }
    
    
}