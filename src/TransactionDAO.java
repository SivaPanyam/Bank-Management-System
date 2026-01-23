import java.sql.*;

/*
 * Handles deposit, withdraw, transfer
 * and transaction history
 */
public class TransactionDAO {

    public void deposit(long accNo, double amt) throws Exception {

        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);

        PreparedStatement p1 =
          con.prepareStatement(
            "UPDATE accounts SET balance=balance+? WHERE account_number=?");
        p1.setDouble(1, amt);
        p1.setLong(2, accNo);
        p1.executeUpdate();

        PreparedStatement p2 =
          con.prepareStatement(
            "INSERT INTO transactions(account_number, txn_type, amount) VALUES (?, 'DEPOSIT', ?)");
        p2.setLong(1, accNo);
        p2.setDouble(2, amt);
        p2.executeUpdate();

        con.commit();
        System.out.println("Deposit Successful");
    }

    public void withdraw(long accNo, double amt) throws Exception {

        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);

        PreparedStatement check =
          con.prepareStatement(
            "SELECT balance FROM accounts WHERE account_number=?");
        check.setLong(1, accNo);

        ResultSet rs = check.executeQuery();
        rs.next();

        if (rs.getDouble(1) < amt) {
            System.out.println("Insufficient Balance");
            return;
        }

        PreparedStatement p1 =
          con.prepareStatement(
            "UPDATE accounts SET balance=balance-? WHERE account_number=?");
        p1.setDouble(1, amt);
        p1.setLong(2, accNo);
        p1.executeUpdate();

        PreparedStatement p2 =
          con.prepareStatement(
            "INSERT INTO transactions VALUES (NULL, ?, 'WITHDRAW', ?, NOW())");
        p2.setLong(1, accNo);
        p2.setDouble(2, amt);
        p2.executeUpdate();

        con.commit();
        System.out.println("Withdraw Successful");
    }

    public void transfer(long from, long to, double amt) throws Exception {
        withdraw(from, amt);
        deposit(to, amt);
        System.out.println("Transfer Successful");
    }

    public void history(long accNo) throws Exception {

        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
          con.prepareStatement(
            "SELECT * FROM transactions WHERE account_number=?");

        ps.setLong(1, accNo);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
              rs.getString("txn_type") + " | " +
              rs.getDouble("amount") + " | " +
              rs.getTimestamp("txn_date")
            );
        }
    }
}
