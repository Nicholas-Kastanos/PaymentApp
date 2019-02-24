package paymentapp;

import java.util.Scanner;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 *
 * @author Nicholas Kastanos
 */
public class PaymentApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username (Q or q to Quit): ");
        String username = scanner.nextLine();
        if (username.equalsIgnoreCase("q")) {
            scanner.close();
            System.exit(0);
        }
        do {
            System.out.print("Enter your password: ");
            String passwrd = scanner.nextLine();
            if (username.equalsIgnoreCase("admin") && passwrd.equalsIgnoreCase("admin")) {
                PaymentApp.changeTransactionType(scanner);
            } else {
                PaymentApp.transactionMenu(scanner, username, passwrd);
            }
            System.out.print("Enter your username (Q or q to Quit): ");
            username = scanner.nextLine();
        } while (!username.equalsIgnoreCase("q"));
        scanner.close();
    }
    
    private static void changeTransactionType(Scanner transactionScanner) {
        System.out.println("This would be performed server-side, and the user would have no knowledge of this.");
        System.out.print("Choose a Transaction Type:\n1) Secure;\n2) Fast;\n3) Insecure;\nEnter the number of your selection:");
        int selection = Integer.parseInt(transactionScanner.nextLine());
        while (selection < 1 || selection > 4) {
            System.out.println("Invalid selection.");
            System.out.print("Choose a Transaction Type:\n1) Secure;\n2) Fast;\n3) Insecure;\nEnter the number of your selection:");
            selection = Integer.parseInt(transactionScanner.nextLine());
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
                System.out.println("Invalid Selection");
                System.exit(1);
        }
    }
    
    private static void transactionMenu(Scanner scanner, final String username, final String passwrd) {
        System.out.println("Successfully Logged In.");
        int selection = 1;
        while (selection != 0) {
            System.out.print("Choose an Option:\n0) Logout;\n1) Transaction;\nEnter the number of your selection:");
            do {
                selection = Integer.parseInt(scanner.nextLine());
            } while (!(selection < 2 && selection >= 0));
            
            switch (selection) {
                case 0:
                    continue;
                case 1:
                    break;
                default:
                    System.out.println("Invalid Selection");
                    System.exit(1);
            }
            
            Injector injector = Guice.createInjector(new PaymentServiceModule());
            PaymentService paymentService = injector.getInstance(PaymentService.class);
            
            System.out.print("Enter the amount to transfer: ");
            double amount = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter the destination of the transfer: ");
            String destination = scanner.nextLine();
            paymentService.makePayment(username, passwrd, amount, destination);
        }
    }
}
