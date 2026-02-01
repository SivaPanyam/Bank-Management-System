import java.util.List;

/*
 * DAO Interface
 * -------------
 * Purpose:
 * - Defines database operations.
 * - Contains ONLY method declarations.
 * - No SQL queries.
 * - No JDBC code.
 *
 * Why interface?
 * - Provides loose coupling.
 * - Implementation can be changed without affecting other layers.
 */
public interface AccountDAO {

    void createAccount(AccountDTO acc) throws Exception;

    AccountDTO login(long accNo, int pin) throws Exception;

    AccountDTO getAccount(long accNo) throws Exception;

    void updateBalance(long accNo, double newBalance) throws Exception;

    void addTransaction(long accNo, String type,
                        double amount, double balanceAfter) throws Exception;

    List<TransactionDTO> getTransactions(long accNo) throws Exception;
}
