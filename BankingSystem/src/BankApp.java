import java.util.List;
import java.util.Scanner;

/*
 * UI Layer (Main Class)
 * --------------------
 * Purpose:
 * - Menu-driven command line interface.
 * - Takes user input.
 * - Displays output.
 * - No business logic.
 * - No database code.
 */
public class BankApp {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        AccountService service = new AccountService();

        while (true) {
            System.out.println("\n1. Create Account\n2. Login\n0. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Account Number: ");
                long accNo = sc.nextLong();

                System.out.print("Customer Name: ");
                sc.nextLine();
                String name = sc.nextLine();

                System.out.print("Account Type: ");
                String type = sc.next();

                System.out.print("Initial Balance: ");
                double bal = sc.nextDouble();

                System.out.print("PIN: ");
                int pin = sc.nextInt();

                service.createAccount(
                    new AccountDTO(accNo, name, type, bal, pin)
                );
                System.out.println("Account Created Successfully");

            } else if (choice == 2) {

                System.out.print("Account Number: ");
                long accNo = sc.nextLong();
                System.out.print("PIN: ");
                int pin = sc.nextInt();

                AccountDTO acc = service.login(accNo, pin);
                if (acc == null) {
                    System.out.println("Invalid Login");
                    continue;
                }

                while (true) {
                    System.out.println(
                        "\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Transaction History\n5. Logout"
                    );
                    int opt = sc.nextInt();

                    if (opt == 1) {
                        System.out.print("Amount: ");
                        service.deposit(accNo, sc.nextDouble());
                        System.out.println("Deposit Successful");

                    } else if (opt == 2) {
                        System.out.print("Amount: ");
                        boolean success =
                            service.withdraw(accNo, sc.nextDouble());
                        System.out.println(success ?
                            "Withdraw Successful" :
                            "Insufficient Balance");

                    } else if (opt == 3) {
                        System.out.println(
                            "Balance: " + service.checkBalance(accNo)
                        );

                    } else if (opt == 4) {
                        List<TransactionDTO> list =
                            service.getTransactions(accNo);
                        for (TransactionDTO tx : list) {
                            System.out.println(
                                tx.getTime() + " | " +
                                tx.getType() + " | " +
                                tx.getAmount() + " | " +
                                tx.getBalanceAfter()
                            );
                        }

                    } else if (opt == 5) {
                        break;
                    }
                }
            } else {
                System.exit(0);
            }
        }
    }
}
