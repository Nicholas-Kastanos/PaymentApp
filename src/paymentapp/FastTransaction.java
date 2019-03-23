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
public class FastTransaction implements Transaction{

    @Override
    public void makeTransaction(String username, String passwrd, double amount, String destination) {
        JOptionPane.showMessageDialog(null, "Transaction of " + amount + " transfered to " + destination);
    }
    
}
