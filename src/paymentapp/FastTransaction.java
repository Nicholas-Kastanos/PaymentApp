package paymentapp;

public class FastTransaction implements Transaction {

    @Override
    public void makeTransaction(String username, String passwrd, double amount, String destination) {
        System.out.println("Transaction of " + amount + " transfered to " + destination);
    }

}
