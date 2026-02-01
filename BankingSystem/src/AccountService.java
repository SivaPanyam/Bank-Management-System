import java.util.List;

/*
 * Service Layer
 * -------------
 * Purpose:
 * - Contains business logic and validations.
 * - Acts as middle layer between UI and DAO.
 * - UI never talks directly to DAO.
 */
public class AccountService {

    private AccountDAO dao = new AccountDAOImpl();

    // Create account
    public void createAccount(AccountDTO acc) throws Exception {
        dao.createAccount(acc);
    }

    // Login
    public AccountDTO login(long accNo, int pin) throws Exception {
        return dao.login(accNo, pin);
    }

    // Deposit money
    public void deposit(long accNo, double amount) throws Exception {
        if (amount <= 0) return;

        AccountDTO acc = dao.getAccount(accNo);
        double newBalance = acc.getBalance() + amount;

        dao.updateBalance(accNo, newBalance);
        dao.addTransaction(accNo, "DEPOSIT", amount, newBalance);
    }

    // Withdraw money
    public boolean withdraw(long accNo, double amount) throws Exception {
        AccountDTO acc = dao.getAccount(accNo);

        if (amount <= 0 || acc.getBalance() < amount)
            return false;

        double newBalance = acc.getBalance() - amount;
        dao.updateBalance(accNo, newBalance);
        dao.addTransaction(accNo, "WITHDRAW", amount, newBalance);
        return true;
    }

    // Check balance
    public double checkBalance(long accNo) throws Exception {
        return dao.getAccount(accNo).getBalance();
    }

    // Transaction history
    public List<TransactionDTO> getTransactions(long accNo)
            throws Exception {
        return dao.getTransactions(accNo);
    }
}
