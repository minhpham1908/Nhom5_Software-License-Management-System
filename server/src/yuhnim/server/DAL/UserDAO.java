package yuhnim.server.DAL;

import yuhnim.rmi.User;
import yuhnim.server.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User> {
    @Override
    public ArrayList<User> getAll(Integer id) {
        return null;
    }

    public User get(String username) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE User_name= '" + username + "'");
            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("User_name"));
                user.setID(resultSet.getInt("User_id"));
                user.setEncryptedPassword(resultSet.getString("Encrypted_password"));
                return user;

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public User get(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user where user.User_id=" + id);
            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("User_name"));
                user.setID(resultSet.getInt("User_id"));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer update(User user) {
        return null;
    }

    @Override
    public Integer delete(User user) {
        return null;
    }


}
