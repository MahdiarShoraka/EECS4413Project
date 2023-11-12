package proj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDAO {

	public Transaction read(int tranID) {
		String sql = "SELECT CardHolderName, ExpirationDate, SecurityCode, "
				+ "ItemID, UserID, TotalCost, Seller FROM Transactions WHERE TransactionID = ?";
		Transaction tr = null;
		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, tranID);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					tr = new Transaction();
					tr.setTransactionID(tranID);
					tr.setCardHolderName(rs.getString("CardHolderName"));
					tr.setExpDate(rs.getString("ExpirationDate"));
					tr.setCvv(rs.getInt("SecurityCode"));
					tr.setItemID(rs.getInt("ItemID"));
					tr.setUserID(rs.getInt("UserID"));
					tr.setTotalCost(rs.getDouble("TotalCost"));
					tr.setSeller(rs.getString("Seller"));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return tr;
	}

	public Transaction create(Transaction tr) {
		String sql = "INSERT INTO Transactions(TransactionID, CreditCardNumber, CardHolderName, ExpirationDate, SecurityCode, "
				+ "ItemID, UserID, TotalCost, Seller) VALUES(?,?,?,?,?,?,?,?,?)";
		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, tr.getTransactionID());
			pstmt.setLong(2, tr.getCardNumber());
			pstmt.setString(3, tr.getCardHolderName());
			pstmt.setString(4, tr.getExpDate());
			pstmt.setInt(5, tr.getCvv());
			pstmt.setInt(6, tr.getItemID());
			pstmt.setInt(7, tr.getUserID());
			pstmt.setDouble(8, tr.getTotalCost());
			pstmt.setString(9, tr.getSeller());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return tr;
	}

//	public Transaction update(long number, Transaction card) {
//		String sql = "UPDATE Transation SET CreditCardNumber = ?, CardHolderName = ?, ExpirationDate = ?, SecurityCode = ? WHERE TransactionID =?";
//		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
//			pstmt.setString(1, card.getCardHolderName());
//			pstmt.setString(2, card.getExpDate());
//			pstmt.setInt(3, card.getCvv());
//			pstmt.setLong(4, number);
//			pstmt.executeUpdate();
//
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		return card;
//	}


	public void delete(int number) {
		String sql = "DELETE FROM Transactions WHERE TransactionID = ?";
		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, number);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
