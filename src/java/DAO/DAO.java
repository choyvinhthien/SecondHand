package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connect.DBconnect;
import dto.Category;
import dto.Product;
import dto.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Part;
import java.io.InputStream;

public class DAO extends DBconnect {

    public User checkExistUser(String username) throws SQLException {
        String queryString = "SELECT * FROM [user] WHERE username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryString);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public User checkExistGmail(String gmail) {
        String query = "SELECT * FROM [user] WHERE email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, gmail);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void doSignup(String username, String password, String name, String email, String address, String phone, String role) {
        String query = "INSERT INTO [user] (username, password, name, email, address, phone, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, email);
            ps.setString(5, address);
            ps.setString(6, phone);
            ps.setString(7, role);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public User doLogin(String argUser, String argPass) {
        User user = null;
        String queryString = "SELECT * from  [user] WHERE (username = ? OR email = ?) AND password = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryString);
            ps.setString(1, argUser);
            ps.setString(2, argUser);
            ps.setString(3, argPass);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                user = new User(result.getInt(1), result.getString(2), result.getString(3),
                result.getString(4), result.getString(5), result.getString(6),
                result.getString(7), result.getString(8));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return user;
    }
    public void changeProfile(String username, String password, String name, String phone, String address){
        String queryString = "UPDATE [user] SET name = ?, phone = ?, address = ? WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryString);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setString(4, username);
            ps.setString(5, password);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void changePassword(int user_id, String passwordChange){
        String queryString = "UPDATE [user] SET password = ? WHERE [user_id] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryString);
            ps.setString(1, passwordChange);
            ps.setInt(2, user_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public User getUserByID(int user_id){
        User user = new User();
        String queryString = "SELECT * FROM [user] WHERE [user_id] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryString);
            ps.setInt(1, user_id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                user = new User(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String queryString = "SELECT * from [user]";

        try (PreparedStatement ps = connection.prepareStatement(queryString);
             ResultSet result = ps.executeQuery()) {

            while (result.next()) {
                User user = new User(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        result.getString(8)
                );
                list.add(user);
            }
        } catch (SQLException e) {
            // Handle the exception according to your application's requirements
            e.printStackTrace();
        }
        return list;
    }
    public User checkEmailLogin(String email){
        User user = null;
        String queryString = "SELECT * from  [user] WHERE email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryString);
            ps.setString(1, email);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                user = new User(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        result.getString(8)
                );
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }
    public boolean checkUsername(String username){
        String queryString = "SELECT * from  [user] WHERE username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryString);
            ps.setString(1, username);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
    public boolean checkEmail(String email){
        String queryString = "SELECT * from  [user] WHERE email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryString);
            ps.setString(1, email);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
    public boolean checkPhoneNumber(String phone){
        String queryString = "SELECT * from  [user] WHERE phone = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryString);
            ps.setString(1, phone);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
    public User checkForgotPasswordAccount(String argUser){
        User user = null;
        String queryString = "SELECT * from  [user] WHERE username = ? OR email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryString);
            ps.setString(1, argUser);
            ps.setString(2, argUser);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                user = new User(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8)
                );
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }
    public void deleteAccount(int user_id){
        String queryString = "DELETE FROM [user] WHERE [user_id] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryString);
            ps.setInt(1, user_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void deleteCategory(int category_id){
        String queryString = "DELETE FROM [category] WHERE [category_id] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryString);
            ps.setInt(1, category_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public List<Product> getProductByUserID(int id) {
        List<Product> list = new ArrayList<>();
        String queryString = "select * from product\n"
                + "where [user_id] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryString);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getBigDecimal(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        getCategoryById(rs.getInt(7)),
                        getUserByID(rs.getInt(8))
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Category getCategoryById(int categoryId) {
        Category category = null;
        String queryString = "SELECT * FROM category WHERE category_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(queryString);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("category_id");
                String name = rs.getString("category_name");
                // Assuming the Category class has a constructor that accepts category_id and category_name
                category = new Category(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        String queryString = "SELECT * from category";

        try (PreparedStatement ps = connection.prepareStatement(queryString);
             ResultSet result = ps.executeQuery()) {

            while (result.next()) {
                Category category = new Category(
                        result.getInt(1),
                        result.getString(2)
                );
                list.add(category);
            }
        } catch (SQLException e) {
            // Handle the exception according to your application's requirements
            e.printStackTrace();
        }
        return list;
    }
    public void addProduct(Product product, List<Part> imageParts){
        String query = "INSERT INTO [product] (name, price, quantity, description, quantity_sold, category_id, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setBigDecimal(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setString(4, product.getDescription());
            ps.setInt(5, product.getQuantitySold());
            ps.setInt(6, product.getCategory().getCategoryId());
            ps.setInt(7, product.getUser().getUserId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String query2 = "SELECT * FROM product WHERE name = ? AND price = ? AND quantity = ? AND description = ? AND quantity_sold = ? AND category_id = ? AND user_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query2);
            ps.setString(1, product.getName());
            ps.setBigDecimal(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setString(4, product.getDescription());
            ps.setInt(5, product.getQuantitySold());
            ps.setInt(6, product.getCategory().getCategoryId());
            ps.setInt(7, product.getUser().getUserId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product.setProductId(rs.getInt(1));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        String query3 = "INSERT INTO images (product_id, img) VALUES (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query3);
            for (Part imagePart : imageParts) {
                InputStream imageInputStream = imagePart.getInputStream();
                byte[] imageBytes = imageInputStream.readAllBytes();
                ps.setInt(1, product.getProductId());
                ps.setBytes(2, imageBytes);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getTotal(String tablename){
        String query = "SELECT COUNT(*) FROM ["+tablename+"]";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public List<Product> pagingProducts(int index, int user_id){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM [product] where [user_id] = ?\n" +
                        "ORDER BY [product_id]\n" +
                        "OFFSET ? ROWS FETCH next 10 ROWS ONLY";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, user_id);
            ps.setInt(2, (index-1)*10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getBigDecimal(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        getCategoryById(rs.getInt(7)),
                        getUserByID(rs.getInt(8))
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<User> pagingAccounts(int index){
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM [user]\n" +
                        "ORDER BY [user_id]\n" +
                        "OFFSET ? ROWS FETCH next 10 ROWS ONLY";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, (index-1)*10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        DAO dao = new DAO();
        System.out.println(dao.getTotal("user"));
    }
}