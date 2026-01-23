import java.sql.*;

/*
 * Handles account related operations
 */
public class AccountDAO {

    // Creates bank account
    public long createAccount(int customerId) throws Exception {

        long accNo = System.currentTimeMillis();
        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
          con.prepareStatement("INSERT INTO accounts VALUES (?, ?, 0)");

        ps.setLong(1, accNo);
        ps.setInt(2, customerId);

        ps.executeUpdate();
        return accNo;
    }

    // Returns current balance
    public double getBalance(long accNo) throws Exception {

        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
          con.prepareStatement(
            "SELECT balance FROM accounts WHERE account_number=?");

        ps.setLong(1, accNo);

        ResultSet rs = ps.executeQuery();
        rs.next();

        return rs.getDouble(1);
    }
}
