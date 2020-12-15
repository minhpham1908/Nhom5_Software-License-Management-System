package yuhnim.server.DAL;

import yuhnim.rmi.Licence;
import yuhnim.server.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LicenceDAO implements DAO<Licence> {
    /**
     * This method get all licences belong to given user by their userID
     *
     * @param userID
     * @return List of Licences
     */
    @Override
    public ArrayList<Licence> getAll(Integer userID) {
        Connection connection = ConnectionFactory.getConnection();
        ArrayList<Licence> licences = new ArrayList<Licence>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM user_has_licence AS uhl , licence " +
                            "WHERE uhl.Licence_id=licence.Licence_id " +
                            "AND uhl.User_id =" + userID);
            while (resultSet.next()){
                Licence licence = new Licence();
                licence.setLicenceID(resultSet.getInt("Licence_id"));
                licence.setTitle(resultSet.getString("Title"));
                licence.setValidThough(resultSet.getTimestamp("Valid_though"));
                licences.add(licence);
            }
            return licences;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Licence get(Integer id) {
        return null;
    }

    @Override
    public Integer update(Licence licence) {
        return null;
    }

    @Override
    public Integer delete(Licence licence) {
        return null;
    }
}
