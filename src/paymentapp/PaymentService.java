package paymentapp;

import com.google.inject.Inject;

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
