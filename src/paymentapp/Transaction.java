package paymentapp;

public interface Transaction {
    public void makeTransaction(final String username, final String passwrd, final double amount, final String destination);
}
