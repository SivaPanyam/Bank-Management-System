import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * DAO Implementation
 * ------------------
 * Purpose:
 * - Implements AccountDAO interface.
 * - Contains all JDBC logic.
 * - Executes SQL queries.
 * - Talks directly to MySQL database.
 */
public class AccountDAOImpl implements AccountDAO {

    // Database credentials
    private static final String URL =
        "jdbc:mysql://localhost:3306/bankdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Creates and returns database connection
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Create new account
    public void createAccount(AccountDTO acc) throws Exception {
        Connection con = getConnection();
        String sql =
            "INSERT INTO accounts VALUES (NULL,?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, acc.getAccountNumber());
        ps.setString(2, acc.getCustomerName());
        ps.setString(3, acc.getAccountType());
        ps.setDouble(4, acc.getBalance());
        ps.setInt(5, acc.getPin());

        ps.executeUpdate();
        con.close();
    }

    // Login validation
    public AccountDTO login(long accNo, int pin) throws Exception {
        Connection con = getConnection();
        String sql =
            "SELECT * FROM accounts WHERE account_number=? AND pin=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, accNo);
        ps.setInt(2, pin);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            AccountDTO acc = new AccountDTO();
            acc.setAccountNumber(rs.getLong("account_number"));
            acc.setCustomerName(rs.getString("customer_name"));
            acc.setAccountType(rs.getString("account_type"));
            acc.setBalance(rs.getDouble("balance"));
            acc.setPin(rs.getInt("pin"));
            con.close();
            return acc;
        }
        con.close();
        return null;
    }

    // Fetch account details
    public AccountDTO getAccount(long accNo) throws Exception {
        Connection con = getConnection();
        String sql =
            "SELECT * FROM accounts WHERE account_number=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, accNo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            AccountDTO acc = new AccountDTO();
            acc.setAccountNumber(accNo);
            acc.setCustomerName(rs.getString("customer_name"));
            acc.setAccountType(rs.getString("account_type"));
            acc.setBalance(rs.getDouble("balance"));
            con.close();
            return acc;
        }
        con.close();
        return null;
    }

    // Update balance
    public void updateBalance(long accNo, double newBalance)
            throws Exception {
        Connection con = getConnection();
        String sql =
            "UPDATE accounts SET balance=? WHERE account_number=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, newBalance);
        ps.setLong(2, accNo);
        ps.executeUpdate();
        con.close();
    }

    // Insert transaction record
    public void addTransaction(long accNo, String type,
                               double amount, double balanceAfter)
                               throws Exception {
        Connection con = getConnection();
        String sql =
            "INSERT INTO transactions VALUES (NULL,?,?,?,?,CURRENT_TIMESTAMP)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, accNo);
        ps.setString(2, type);
        ps.setDouble(3, amount);
        ps.setDouble(4, balanceAfter);
        ps.executeUpdate();
        con.close();
    }

    // Fetch transaction history
    public List<TransactionDTO> getTransactions(long accNo)
            throws Exception {
        Connection con = getConnection();
        String sql =
            "SELECT * FROM transactions WHERE account_number=? ORDER BY transaction_time DESC";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, accNo);
        ResultSet rs = ps.executeQuery();

        List<TransactionDTO> list = new ArrayList<>();

        while (rs.next()) {
            TransactionDTO tx = new TransactionDTO();
            tx.setType(rs.getString("transaction_type"));
            tx.setAmount(rs.getDouble("amount"));
            tx.setBalanceAfter(rs.getDouble("balance_after"));
            tx.setTime(rs.getTimestamp("transaction_time"));
            list.add(tx);
        }
        con.close();
        return list;
    }
}
