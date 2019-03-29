package paymentapp;

import javax.swing.JOptionPane;

public class InsecureTransaction implements Transaction {

    @Override
    public void makeTransaction(String username, String passwrd, double amount, String destination) {
        JOptionPane.showMessageDialog(null, "Your username " + username + " and password " + passwrd + " have been broadcast publicly.");
    }

}
