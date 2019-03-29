package paymentapp;

import com.google.inject.Inject;
import java.util.Scanner;

public class PaymentService {

    private Transaction transaction;

    @Inject
    public PaymentService(Transaction transaction) {
        this.transaction = transaction;
    }

    public void makePayment(final String username, final String passwrd, final double amount, final String destination) {
        transaction.makeTransaction(username, passwrd, amount, destination);
    }

    public static void changeTransactionType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a Transaction Type:\\n1) Secure;\\n2) Fast;\\n3) Insecure;\\nEnter the number of your selection.");
        int selection = Integer.parseInt(scanner.nextLine());
        /* 
        int selection = 2;
        System.out.println(selection); */
        while (selection < 1 || selection > 4) {
            System.out.println("Invalid selection.");
            System.out.println("Choose a Transaction Type:\n1) Secure;\n2) Fast;\n3) Insecure;\nEnter the number of your selection:");
            selection = Integer.parseInt(scanner.nextLine());
        }
        switch (selection) {
            case 1:
                TransactionProvider.setTransactionType(TransactionType.SECURE);
                System.out.println("Set Transaction Type to SECURE.");
                break;
            case 2:
                TransactionProvider.setTransactionType(TransactionType.FAST);
                System.out.println("Set Transaction Type to FAST.");
                break;
            case 3:
                TransactionProvider.setTransactionType(TransactionType.INSECURE);
                System.out.println("Set Transaction Type to INSECURE.");
                break;
            default:
                System.out.println("Invalid Selection.");
                System.exit(1);
        }
    }

    public void transactionMenu(final String username, final String passwrd) {
        Scanner scanner = new Scanner(System.in);
        int selection = 1;
        while (selection != 0) {
            do {
                System.out.println("Choose an Option:\n0) Logout;\n1) Transaction;\nEnter the number of your selection.");
                selection = Integer.parseInt(scanner.nextLine());
                /* if (selection == 2) {
                    selection = 0;
                } else {
                    selection = 1;
                }
                System.out.println(selection); */
            } while (!(selection < 2 && selection >= 0));
            switch (selection) {
                case 0:
                    continue;
                case 1:
                    break;
                default:
                    System.out.println("Invalid Selection.");
                    System.exit(1);
            }
            System.out.println("Enter the amount to transfer (Use numbers only).");
            double amount = Double.parseDouble(scanner.nextLine());
            /* selection++;
            double amount = 100;
            System.out.println(amount); */
            System.out.println("Enter the destination of the transfer:");
            String destination = scanner.nextLine();
            
            /* String destination = "Destination Account";
            System.out.println(destination); */
            this.makePayment(username, passwrd, amount, destination); 
        }
    }
}
