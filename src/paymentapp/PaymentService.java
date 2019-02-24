/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paymentapp;

import com.google.inject.Inject;

/**
 *
 * @author nicho
 */
public class PaymentService {
    private Transaction transaction;
    
    @Inject
    public PaymentService(Transaction transaction){
        this.transaction = transaction;
    }
    
    public void makePayment(final String username, final String passwrd, final double amount, final String destination){
        transaction.makeTransaction(username, passwrd, amount, destination);
    }
}
