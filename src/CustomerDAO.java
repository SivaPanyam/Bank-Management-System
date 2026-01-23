import java.sql.*;

/*
 * Handles customer related database operations
 */
public class CustomerDAO {

    // Creates customer and returns generated customer_id
    public int createCustomer(Customer c) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql =
          "INSERT INTO customers(name, phone, email, pin) VALUES (?, ?, ?, ?)";

        PreparedStatement ps =
          con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, c.getName());
        ps.setString(2, c.getPhone());
        ps.setString(3, c.getEmail());
        ps.setInt(4, c.getPin());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();

        return rs.getInt(1);
    }

    // Validates login using account number and pin
    public boolean validateLogin(long accNo, int pin) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql =
          "SELECT * FROM customers c JOIN accounts a " +
          "ON c.customer_id=a.customer_id " +
          "WHERE a.account_number=? AND c.pin=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, accNo);
        ps.setInt(2, pin);

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
}
