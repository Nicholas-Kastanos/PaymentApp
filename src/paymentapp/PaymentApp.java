package paymentapp;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javax.swing.JOptionPane;

public class PaymentApp {

    public static void main(String[] args) {
        String username = JOptionPane.showInputDialog("Enter your username (Q or q to Quit).");
        if (username.equalsIgnoreCase("q")) {
            System.exit(0);
        }
        do {
            String passwrd = JOptionPane.showInputDialog("Enter your password.");
            if (username.equalsIgnoreCase("admin") && passwrd.equalsIgnoreCase("admin")) {
                PaymentService.changeTransactionType();
            } else {
                JOptionPane.showMessageDialog(null, "Successfully Logged In.");
                Injector injector = Guice.createInjector(new PaymentServiceModule());
                PaymentService paymentService = injector.getInstance(PaymentService.class);
                paymentService.transactionMenu(username, passwrd);
            }
            username = JOptionPane.showInputDialog("Enter your username (Q or q to Quit).");
        } while (!username.equalsIgnoreCase("q"));
    }
}
