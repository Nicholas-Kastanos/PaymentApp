/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paymentapp;

import com.google.inject.Provider;
import javax.swing.JOptionPane;

/**
 *
 * @author nicho
 */
public class TransactionProvider implements Provider<Transaction>{
    
    private static TransactionType type = TransactionType.SECURE;
    
    @Override
    public Transaction get() {
        switch(type){
            case SECURE:
                JOptionPane.showMessageDialog(null, "Secure Transaction Mode");
                return new SecureTransaction();
            case FAST:
                JOptionPane.showMessageDialog(null, "Fast Transaction Mode");
                return new FastTransaction();
            case INSECURE:
                JOptionPane.showMessageDialog(null, "Insecure Transaction Mode");
                return new InsecureTransaction();
            default:
                JOptionPane.showMessageDialog(null, "Invalid Selection. Using Secure Transactions", "Error", JOptionPane.WARNING_MESSAGE);
                return new SecureTransaction();
        }
    }
    public static void setTransactionType(TransactionType type){
        TransactionProvider.type = type;
    }
    
}