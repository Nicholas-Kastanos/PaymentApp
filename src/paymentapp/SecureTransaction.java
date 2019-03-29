package paymentapp;

import javax.swing.JOptionPane;

public class SecureTransaction implements Transaction {

    @Override
    public void makeTransaction(String username, String passwrd, double amount, String destination) {
        String check = JOptionPane.showInputDialog(amount + " is to be transfered to " + destination + "\nPlease re-enter your password to continue.");
        if (check.equals(passwrd)) {
            JOptionPane.showMessageDialog(null, "Transfer Successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Transfer Successful!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
