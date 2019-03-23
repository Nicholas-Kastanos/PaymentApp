package paymentapp;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicholas Kastanos
 */
public class PaymentApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String username = JOptionPane.showInputDialog("Enter your username (Q or q to Quit): ");
        if (username.equalsIgnoreCase("q")) {
            System.exit(0);
        }
        do {
            String passwrd = JOptionPane.showInputDialog("Enter your password: ");
            if (username.equalsIgnoreCase("admin") && passwrd.equalsIgnoreCase("admin")) {
                PaymentApp.changeTransactionType();
            } else {
                PaymentApp.transactionMenu(username, passwrd);
            }
            username = JOptionPane.showInputDialog("Enter your username (Q or q to Quit): ");
        } while (!username.equalsIgnoreCase("q"));
    }
    
    private static void changeTransactionType() {
        //System.out.println("This would be performed server-side, and the user would have no knowledge of this.");
        int selection = Integer.parseInt(JOptionPane.showInputDialog("Choose a Transaction Type:\n1) Secure;\n2) Fast;\n3) Insecure;\nEnter the number of your selection:"));
        while (selection < 1 || selection > 4) {
            JOptionPane.showMessageDialog(null, "Invalid selection.", "Error", JOptionPane.WARNING_MESSAGE);
            selection = Integer.parseInt(JOptionPane.showInputDialog("Choose a Transaction Type:\n1) Secure;\n2) Fast;\n3) Insecure;\nEnter the number of your selection:"));
        }
        switch (selection) {
            case 1:
                TransactionProvider.setTransactionType(TransactionType.SECURE);
                JOptionPane.showMessageDialog(null,"Set Transaction Type to SECURE.");
                break;
            case 2:
                TransactionProvider.setTransactionType(TransactionType.FAST);
                JOptionPane.showMessageDialog(null,"Set Transaction Type to FAST.");
                break;
            case 3:
                TransactionProvider.setTransactionType(TransactionType.INSECURE);
                JOptionPane.showMessageDialog(null,"Set Transaction Type to INSECURE.");
                break;
            default:
                JOptionPane.showMessageDialog(null,"Invalid Selection.", "Error",JOptionPane.WARNING_MESSAGE);
                System.exit(1);
        }
    }
    
    private static void transactionMenu(final String username, final String passwrd) {
        JOptionPane.showMessageDialog(null, "Successfully Logged In.");
        Injector injector = Guice.createInjector(new PaymentServiceModule());
        PaymentService paymentService = injector.getInstance(PaymentService.class);
        int selection = 1;
        while (selection != 0) {
            do {
                selection = Integer.parseInt(JOptionPane.showInputDialog("Choose an Option:\n0) Logout;\n1) Transaction;\nEnter the number of your selection:"));
            } while (!(selection < 2 && selection >= 0));
            
            switch (selection) {
                case 0:
                    continue;
                case 1:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Selection.","Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
            }
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount to transfer: "));
            String destination = JOptionPane.showInputDialog("Enter the destination of the transfer: ");
            paymentService.makePayment(username, passwrd, amount, destination);
        }
    }
}
