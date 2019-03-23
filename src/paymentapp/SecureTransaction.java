/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paymentapp;

import javax.swing.JOptionPane;

/**
 *
 * @author nicho
 */
public class SecureTransaction implements Transaction{

    @Override
    public void makeTransaction(String username, String passwrd, double amount, String destination) {
        String check = JOptionPane.showInputDialog(amount + " is to be transfered to " + destination + "\nPlease re-enter your password to continue: ");
        if(check.equals(passwrd)){
            JOptionPane.showMessageDialog(null, "Transfer Successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Transfer Successful!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
