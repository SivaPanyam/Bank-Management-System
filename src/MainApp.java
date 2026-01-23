import java.util.Scanner;

/*
 * Entry point of the application
 * Menu-driven CLI
 */
public class MainApp {

    static long loggedAccount = -1;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        CustomerDAO cdao = new CustomerDAO();
        AccountDAO adao = new AccountDAO();
        TransactionDAO tdao = new TransactionDAO();

        while (true) {
            System.out.println(
              "\n1.Create 2.Login 3.Deposit 4.Withdraw 5.Transfer 6.Balance 7.History 8.Exit");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("PIN: ");
                    int pin = sc.nextInt();

                    int cid = cdao.createCustomer(
                        new Customer(name, phone, email, pin));

                    long acc = adao.createAccount(cid);
                    System.out.println("Account Created: " + acc);
                    break;

                case 2:
                    System.out.print("Account No: ");
                    long a = sc.nextLong();
                    System.out.print("PIN: ");
                    pin = sc.nextInt();

                    if (cdao.validateLogin(a, pin)) {
                        loggedAccount = a;
                        System.out.println("Login Successful");
                    } else {
                        System.out.println("Invalid Login");
                    }
                    break;

                case 3:
                    System.out.print("Amount: ");
                    tdao.deposit(loggedAccount, sc.nextDouble());
                    break;

                case 4:
                    System.out.print("Amount: ");
                    tdao.withdraw(loggedAccount, sc.nextDouble());
                    break;

                case 5:
                    System.out.print("To Account: ");
                    long to = sc.nextLong();
                    System.out.print("Amount: ");
                    tdao.transfer(loggedAccount, to, sc.nextDouble());
                    break;

                case 6:
                    System.out.println("Balance: " +
                      adao.getBalance(loggedAccount));
                    break;

                case 7:
                    tdao.history(loggedAccount);
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}
