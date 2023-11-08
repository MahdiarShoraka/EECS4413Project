package proj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    public List<Item> readAll() {
        String sql = "SELECT * FROM Items";
        List<Item> items = new ArrayList<>();

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Item item = createItemFromResultSet(rs);
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public Item read(int itemId) {
        String sql = "SELECT * FROM Items WHERE ItemID = ?";
        Item item = null;

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itemId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    item = createItemFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    public List<Item> readByKeyword(String keyword) {
        String sql = "SELECT * FROM Items WHERE ItemDescription LIKE ?";
        List<Item> items = new ArrayList<>();

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + keyword + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Item item = createItemFromResultSet(rs);
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public boolean create(Item item) {
        String sql = "INSERT INTO Items (ItemName, CurrentBiddingPrice, AuctionType, RemainingTime, ExpeditedShippingCost, SellerUserID, ItemDescription) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            setItemValuesInStatement(item, stmt);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int itemId) {
        String sql = "DELETE FROM Items WHERE ItemID = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itemId);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Item createItemFromResultSet(ResultSet rs) throws SQLException {
        Item item = new Item();
        item.setItemID(rs.getInt("ItemID"));
        item.setItemName(rs.getString("ItemName"));
        item.setCurrentBiddingPrice(rs.getDouble("CurrentBiddingPrice"));
        item.setAuctionType(rs.getString("AuctionType"));
        item.setRemainingTime(rs.getInt("RemainingTime"));
        item.setExpeditedShippingCost(rs.getDouble("ExpeditedShippingCost"));
        item.setSellerUserID(rs.getInt("SellerUserID"));
        item.setItemDescription(rs.getString("ItemDescription"));
        return item;
    }

    private void setItemValuesInStatement(Item item, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, item.getItemName());
        stmt.setDouble(2, item.getCurrentBiddingPrice());
        stmt.setString(3, item.getAuctionType());
        stmt.setInt(4, item.getRemainingTime());
        stmt.setDouble(5, item.getExpeditedShippingCost());
        stmt.setInt(6, item.getSellerUserID());
        stmt.setString(7, item.getItemDescription());
    }
}
