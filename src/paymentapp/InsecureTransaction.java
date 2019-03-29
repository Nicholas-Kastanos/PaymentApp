package paymentapp;

public class InsecureTransaction implements Transaction {

    @Override
    public void makeTransaction(String username, String passwrd, double amount, String destination) {
        System.out.println("Your username " + username + " and password " + passwrd + " have been broadcast publicly.");
    }

}
