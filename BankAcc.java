import java.util.Scanner;

class BankAccount {
    private String name;
    private String accNumber;
    private String userId;
    private String password;
    private double balance;

    // ✅ Corrected Constructor Name
    public BankAccount(String name, String accNumber, String userId, String password, double balance) {
        this.name = name;
        this.accNumber = accNumber;
        this.userId = userId;
        this.password = password;
        this.balance = balance;
    }

    // ✅ Deposit Money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // ✅ Withdraw Money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("Remaining Balance: $" + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // ✅ Display Account Details
    public void showAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accNumber);
        System.out.println("User ID: " + userId);
        System.out.println("Balance: $" + balance);
    }

    // ✅ Verify Login
    public boolean verifyLogin(String enteredUserId, String enteredPassword) {
        return this.userId.equals(enteredUserId) && this.password.equals(enteredPassword);
    }
}

// ✅ Main Class
public class BankAcc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ✅ Take User Input for Account Creation
        System.out.println("Enter Your Name:");
        String name = sc.nextLine();

        System.out.println("Enter Account Number:");
        String accNumber = sc.nextLine();

        System.out.println("Enter User ID:");
        String userId = sc.nextLine();

        System.out.println("Enter Password:");
        String password = sc.nextLine();

        System.out.println("Enter Initial Balance:");
        double balance = sc.nextDouble();

        // ✅ Corrected Object Creation
        BankAccount account = new BankAccount(name, accNumber, userId, password, balance);

        System.out.println("Welcome to the Bank System!");

        // ✅ Login System
        sc.nextLine(); // Consume leftover newline
        System.out.print("Enter User ID: ");
        String enteredUserId = sc.nextLine();

        System.out.print("Enter Password: ");
        String enteredPassword = sc.nextLine();

        if (account.verifyLogin(enteredUserId, enteredPassword)) {
            System.out.println("Login Successful!");

            // ✅ User Menu
            while (true) {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Deposit Money");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Show Account Balance");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        account.showAccountDetails();
                        break;
                    case 4:
                        System.out.println("Thank you for using the bank system!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } else {
            System.out.println("Invalid login credentials. Access denied.");
        }

        sc.close();
    }
}
