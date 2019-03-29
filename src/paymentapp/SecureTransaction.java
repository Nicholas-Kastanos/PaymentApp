package paymentapp;

public class SecureTransaction implements Transaction {

    @Override
    public void makeTransaction(String username, String passwrd, double amount, String destination) {
        String check = amount + " is to be transfered to " + destination;
        System.out.println(check);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < check.length(); i++) {
            sb.append((char) (check.charAt(i) + i));
        }
        System.out.println(sb);
        System.out.println("Transfer Successfully Encoded!");

    }
}
