package proj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public List<User> readAll() {
        String sql = "SELECT * FROM Users";
        List<User> users = new ArrayList<>();

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = createUserFromResultSet(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public User read(int userId) {
        String sql = "SELECT * FROM Users WHERE UserID = ?";
        User user = null;

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = createUserFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    public User readByUsername(String username) {
        String sql = "SELECT * FROM Users WHERE UserName = ?";
        User user = null;

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = createUserFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean create(User user) {
        String sql = "INSERT INTO Users (UserName, Password, FirstName, LastName, StreetName, StreetNumber, City, Country, PostalCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            setUserValuesInStatement(user, stmt);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int userId) {
        String sql = "DELETE FROM Users WHERE UserID = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public User authenticate(String userName, String password) {
        String sql = "SELECT * FROM Users WHERE UserName = ? AND Password = ?";
        User user = null;

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userName);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = createUserFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    

    private User createUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserID(rs.getInt("UserID"));
        user.setUserName(rs.getString("UserName"));
        user.setPassword(rs.getString("Password"));
        user.setFirstName(rs.getString("FirstName"));
        user.setLastName(rs.getString("LastName"));
        user.setStreetName(rs.getString("StreetName"));
        user.setStreetNumber(rs.getString("StreetNumber"));
        user.setCity(rs.getString("City"));
        user.setCountry(rs.getString("Country"));
        user.setPostalCode(rs.getString("PostalCode"));
        return user;
    }

    private void setUserValuesInStatement(User user, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, user.getUserName());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getFirstName());
        stmt.setString(4, user.getLastName());
        stmt.setString(5, user.getStreetName());
        stmt.setString(6, user.getStreetNumber());
        stmt.setString(7, user.getCity());
        stmt.setString(8, user.getCountry());
        stmt.setString(9, user.getPostalCode());
    }
}
