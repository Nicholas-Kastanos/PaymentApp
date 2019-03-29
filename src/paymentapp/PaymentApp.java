package paymentapp;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javax.swing.JOptionPane;

public class PaymentApp {

    public static void main(String[] args) {
        String username = JOptionPane.showInputDialog("Enter your username (Q or q to Quit).");
        /* System.out.println("Enter your username (Q or q to Quit).");
        String username = "DriverUser";
        System.out.println(username); */
        if (username.equalsIgnoreCase("q")) {
            System.exit(0);
        }
        do {
            String passwrd = JOptionPane.showInputDialog("Enter your password.");
            /* System.out.println("Enter your password.");
            String passwrd;
            if(username.equals("admin")){
                passwrd = "admin";
            }else{
                passwrd = "DriverPasswrd";
            }
            System.out.println(passwrd); */
            if (username.equalsIgnoreCase("admin") && passwrd.equalsIgnoreCase("admin")) {
                PaymentService.changeTransactionType();
            } else {
                JOptionPane.showMessageDialog(null, "Successfully Logged In.");
                //System.out.println("Successfully Logged In.");
                Injector injector = Guice.createInjector(new PaymentServiceModule());
                PaymentService paymentService = injector.getInstance(PaymentService.class);
                paymentService.transactionMenu(username, passwrd);
            }
            username = JOptionPane.showInputDialog("Enter your username (Q or q to Quit).");
            /* System.out.println("Enter your username (Q or q to Quit).");
            if(username.equals("DriverUser")){
                username = "admin";
            } else if (username.equals("admin")){
                username = "DriverUser2";
            }else {
                username = "q";
            }
            System.out.println(username); */
        } while (!username.equalsIgnoreCase("q"));
    }
}
