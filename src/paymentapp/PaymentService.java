package paymentapp;

import com.google.inject.Inject;
import javax.swing.JOptionPane;

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
        int selection = Integer.parseInt(JOptionPane.showInputDialog("Choose a Transaction Type:\n1) Secure;\n2) Fast;\n3) Insecure;\nEnter the number of your selection."));
        while (selection < 1 || selection > 4) {
            JOptionPane.showMessageDialog(null, "Invalid selection.", "Error", JOptionPane.WARNING_MESSAGE);
            selection = Integer.parseInt(JOptionPane.showInputDialog("Choose a Transaction Type:\n1) Secure;\n2) Fast;\n3) Insecure;\nEnter the number of your selection:"));
        }
        switch (selection) {
            case 1:
                TransactionProvider.setTransactionType(TransactionType.SECURE);
                JOptionPane.showMessageDialog(null, "Set Transaction Type to SECURE.");
                break;
            case 2:
                TransactionProvider.setTransactionType(TransactionType.FAST);
                JOptionPane.showMessageDialog(null, "Set Transaction Type to FAST.");
                break;
            case 3:
                TransactionProvider.setTransactionType(TransactionType.INSECURE);
                JOptionPane.showMessageDialog(null, "Set Transaction Type to INSECURE.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Selection.", "Error", JOptionPane.WARNING_MESSAGE);
                System.exit(1);
        }
    }

    public void transactionMenu(final String username, final String passwrd) {
        int selection = 1;
        while (selection != 0) {
            do {
                selection = Integer.parseInt(JOptionPane.showInputDialog("Choose an Option:\n0) Logout;\n1) Transaction;\nEnter the number of your selection."));
            } while (!(selection < 2 && selection >= 0));
            switch (selection) {
                case 0:
                    continue;
                case 1:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Selection.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
            }
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount to transfer (Use numbers only)."));
            String destination = JOptionPane.showInputDialog("Enter the destination of the transfer:");
            this.makePayment(username, passwrd, amount, destination);
        }
    }
}
