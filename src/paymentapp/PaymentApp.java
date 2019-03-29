package paymentapp;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.Scanner;

public class PaymentApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username (Q or q to Quit).");
        String username = scanner.nextLine();
        /* String username = "DriverUser";
        System.out.println(username); */
        if (username.equalsIgnoreCase("q")) {
            System.exit(0);
        }
        do {
            System.out.println("Enter your password.");
            String passwrd = scanner.nextLine();
            /* String passwrd;
            if(username.equals("admin")){
                passwrd = "admin";
            }else{
                passwrd = "DriverPasswrd";
            }
            System.out.println(passwrd); */
            if (username.equalsIgnoreCase("admin") && passwrd.equalsIgnoreCase("admin")) {
                PaymentService.changeTransactionType();
            } else {
                System.out.println("Successfully Logged In.");
                Injector injector = Guice.createInjector(new PaymentServiceModule());
                PaymentService paymentService = injector.getInstance(PaymentService.class);
                paymentService.transactionMenu(username, passwrd);
            }
            scanner = new Scanner(System.in);
            System.out.println("Enter your username (Q or q to Quit).");
            username = scanner.nextLine();
            
            /* if(username.equals("DriverUser")){
                username = "admin";
            } else if (username.equals("admin")){
                username = "DriverUser2";
            }else {
                username = "q";
            }
            System.out.println(username); */
        } while (!username.equalsIgnoreCase("q"));
        scanner.close();
    }
}
