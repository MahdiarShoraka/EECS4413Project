package proj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CardDAO {

	public List<CreditCard> readAll() {
		String sql = "SELECT CreditCardNumber, CardHolderName, ExpirationDate, SecurityCode FROM CreditCards";
		List<CreditCard> cards = new ArrayList<>();
		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				CreditCard card = new CreditCard();
				card.setCardHolderName(rs.getString("CardHolderName"));
				card.setCardNumber(rs.getLong("CreditCardNumber"));
				card.setCvv(rs.getInt("SecurityCode"));
				card.setExpDate(rs.getString("ExpirationDate"));
				cards.add(card);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return cards;
	}

	public CreditCard read(long number) {
		String sql = "SELECT CardHolderName, ExpirationDate, SecurityCode FROM CreditCards WHERE CreditCardNumber = ?";
		CreditCard card = null;
		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, number);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					card = new CreditCard();
					card.setCardNumber(number);
					card.setCardHolderName(rs.getString("CardHolderName"));
					card.setExpDate(rs.getString("ExpirationDate"));
					card.setCvv(rs.getInt("SecurityCode"));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return card;
	}

	public CreditCard create(CreditCard card) {
		String sql = "INSERT INTO CreditCards(CreditCardNumber, CardHolderName, ExpirationDate, SecurityCode) VALUES(?,?,?,?)";
		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, card.getCardNumber());
			pstmt.setString(2, card.getCardHolderName());
			pstmt.setString(3, card.getExpDate());
			pstmt.setInt(4, card.getCvv());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return card;
	}

	public CreditCard update(long number, CreditCard card) {
		String sql = "UPDATE CreditCards SET CardHolderName = ?, ExpirationDate = ?, SecurityCode = ? WHERE CreditCardNumber =?";
		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, card.getCardHolderName());
			pstmt.setString(2, card.getExpDate());
			pstmt.setInt(3, card.getCvv());
			pstmt.setLong(4, number);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return card;
	}

	public void delete(long number) {
		String sql = "DELETE FROM CreditCards WHERE CreditCardNumber = ?";
		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, number);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
