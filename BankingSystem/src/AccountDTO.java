import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;

/*
 * DTO (Data Transfer Object)
 * -------------------------
 * Purpose:
 * - Used to transfer data between UI, Service, and DAO layers.
 * - Contains ONLY variables, constructors, getters, and setters.
 * - No database code.
 * - No business logic.
 */
public class AccountDTO {

    // Account-related data
    private long accountNumber;
    private String customerName;
    private String accountType;
    private double balance;
    private int pin;

    // Stores transaction history for this account
    private List<TransactionDTO> transactions = new ArrayList<>();

    // Default constructor
    public AccountDTO() {}

    // Parameterized constructor
    public AccountDTO(long accountNumber, String customerName,
                      String accountType, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
        this.pin = pin;
    }

    // Getters and Setters
    public long getAccountNumber() { return accountNumber; }
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() { return balance; }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPin() { return pin; }
    public void setPin(int pin) {
        this.pin = pin;
    }

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }
}

/*
 * TransactionDTO
 * --------------
 * Non-public class in the same file.
 * Represents one transaction (deposit or withdraw).
 */
class TransactionDTO {

    private String type;          // DEPOSIT or WITHDRAW
    private double amount;
    private double balanceAfter;
    private Timestamp time;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public double getBalanceAfter() { return balanceAfter; }
    public void setBalanceAfter(double balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public Timestamp getTime() { return time; }
    public void setTime(Timestamp time) { this.time = time; }
}
