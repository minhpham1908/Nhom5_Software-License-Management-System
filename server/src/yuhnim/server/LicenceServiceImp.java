package yuhnim.server;

import yuhnim.rmi.LicenceData;
import yuhnim.rmi.LicenceService;
import yuhnim.rmi.User;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * yuhnim.server.LicenceServiceImp
 */
public class LicenceServiceImp extends UnicastRemoteObject implements LicenceService {
    private static final long serialVersionUID = 1L;

    private static String DB_URL = "jdbc:mysql://mysql:3306/licence";
    private static String USER_NAME = "root";
    private static String PASSWORD = "secret";

    public LicenceServiceImp() throws RemoteException {
        super();
    }
    
    @Override
    public LicenceData getLicence(User user) {
        LicenceData licenceData = null;
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            //create statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            ResultSet rs = stmt.executeQuery("select * from LicenceData, User where User.name = "+user.getName());
            while (rs.next()) {
                //Retrieve by column name
                String id = rs.getString("licenceID");
                Date age = rs.getDate("validThought");
                ArrayList<String> first = (ArrayList<String>) rs.getArray("productName");

                licenceData = new LicenceData(id, age, first);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        Date now =  new Date();
//        ArrayList<String> products = new ArrayList<String>();
//        products.add("some product");
//        LicenceData licenceData = new LicenceData("1234AD",now , products);
        return licenceData;
    }

    private static Connection getConnection(String dbUrl, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    
    
}