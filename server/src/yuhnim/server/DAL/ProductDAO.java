package yuhnim.server.DAL;

import yuhnim.rmi.Product;
import yuhnim.rmi.User;
import yuhnim.server.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements DAO<Product> {
    @Override
    public ArrayList<Product> getAll(Integer licenceId) {
        Connection connection = ConnectionFactory.getConnection();
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM licence_for_product AS lfp, product " +
                            "where lfp.Product_id = product.Product_id " +
                            "and lfp.Licence_id=" + licenceId);
            while (resultSet.next()) {
                Product product = new Product();
                product.setID(resultSet.getInt("Product_id"));
                product.setName(resultSet.getNString("Product_name"));
                products.add(product);
            }
            return products;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Product get(Integer id) {
        return null;
    }

    @Override
    public Integer update(Product product) {
        return null;
    }

    @Override
    public Integer delete(Product product) {
        return null;
    }
}
