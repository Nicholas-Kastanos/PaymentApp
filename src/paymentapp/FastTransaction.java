package paymentapp;

import javax.swing.JOptionPane;

public class FastTransaction implements Transaction {

    @Override
    public void makeTransaction(String username, String passwrd, double amount, String destination) {
        JOptionPane.showMessageDialog(null, "Transaction of " + amount + " transfered to " + destination);
        //System.out.println("Transaction of " + amount + " transfered to " + destination);
    }

}
