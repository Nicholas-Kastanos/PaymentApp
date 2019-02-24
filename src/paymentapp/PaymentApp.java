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
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String passwrd = scanner.nextLine();
        System.out.println("Successfully Logged In.");
        System.out.print("Choose a Transaction Type:\n1) Secure;\n2) Fast;\n3) Insecure;\nEnter the number of your selection:");
        int selection = 0;
        do{
            selection = Integer.parseInt(scanner.nextLine());
        } while(!(selection < 4 && selection > 0));
        
        switch(selection){
            case 1:
                TransactionProvider.setTransactionType(TransactionType.SECURE);
                break;
            case 2:
                TransactionProvider.setTransactionType(TransactionType.FAST);
                break;
            case 3:
                TransactionProvider.setTransactionType(TransactionType.INSECURE);
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
