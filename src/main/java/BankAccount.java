import java.util.Scanner;



public class BankAccount {

    private int balance;
    private int previousTransaction;
    private String customerName;
    private String customerId;

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    public void withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    public void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your id is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check balance:");
        System.out.println("B. Deposit:");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction:");
        System.out.println("E. Exit");

        do {
            System.out.print("=".repeat(30));
            System.out.println("\nEnter an option: ");
            System.out.print("=".repeat(30));
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {

                case 'A':
                    System.out.print("-".repeat(30));
                    System.out.println("\nBalance = " + balance);
                    System.out.print("-".repeat(30));
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.print("-".repeat(30));
                    System.out.println("\nEnter amount to deposit: ");
                    System.out.print("-".repeat(30));
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.print("-".repeat(30));
                    System.out.println("\nEnter amount to withdraw:");
                    System.out.print("-".repeat(30));
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.print("-".repeat(30));
                    getPreviousTransaction();
                    System.out.print("-".repeat(30));
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.print("*".repeat(30));

                default:
                    System.out.println("Invalid Option! Please enter again:");
            }
        }while ( option != 'E');
        System.out.println("Thanks for services!");
    }

}
