/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paymentapp;

import com.google.inject.Provider;

/**
 *
 * @author nicho
 */
public class TransactionProvider implements Provider<Transaction>{
    
    private static TransactionType type = TransactionType.INSECURE;
    
    @Override
    public Transaction get() {
        switch(type){
            case SECURE:
                System.out.println("Secure Transaction Mode");
                return new SecureTransaction();
            case FAST:
                System.out.println("Fast Transaction Mode");
                return new FastTransaction();
            case INSECURE:
                System.out.println("Insecure Transaction Mode");
                return new InsecureTransaction();
            default:
                System.out.println("Invalid Selection. Using Secure Transactions");
                return new SecureTransaction();
        }
    }
    public static void setTransactionType(TransactionType type){
        TransactionProvider.type = type;
    }
    
}