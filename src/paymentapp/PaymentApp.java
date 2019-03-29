package paymentapp;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.Scanner;

public class PaymentApp {

    public static void main(String[] args) {
        System.out.println("Enter your username (Q or q to Quit).");
        String username = "DriverUser";
        System.out.println(username);
        if (username.equalsIgnoreCase("q")) {
            System.exit(0);
        }
        do {
            System.out.println("Enter your password.");
            String passwrd;
            if(username.equals("admin")){
                passwrd = "admin";
            }else{
                passwrd = "DriverPasswrd";
            }
            System.out.println(passwrd); 
            if (username.equalsIgnoreCase("admin") && passwrd.equalsIgnoreCase("admin")) {
                PaymentApp.changeTransactionType();
            } else {
                System.out.println("Successfully Logged In.");
                PaymentApp.transactionMenu(username, passwrd);
            }
            System.out.println("Enter your username (Q or q to Quit).");
            if(username.equals("DriverUser")){
                username = "admin";
            } else if (username.equals("admin")){
                username = "DriverUser2";
            }else {
                username = "q";
            }
            System.out.println(username); 
        } while (!username.equalsIgnoreCase("q"));
    }
    
     public static void changeTransactionType() {
        System.out.println("Choose a Transaction Type:\\n1) Secure;\\n2) Fast;\\n3) Insecure;\\nEnter the number of your selection.");
        int selection = 2;
        System.out.println(selection); 
        while (selection < 1 || selection > 4) {
            System.out.println("Invalid selection.");
            System.out.println("Choose a Transaction Type:\n1) Secure;\n2) Fast;\n3) Insecure;\nEnter the number of your selection:");
            selection = 1;
        }
        switch (selection) {
            case 1:
                TransactionProvider.setTransactionType(TransactionType.SECURE);
                System.out.println("Set Transaction Type to SECURE.");
                break;
            case 2:
                TransactionProvider.setTransactionType(TransactionType.FAST);
                System.out.println("Set Transaction Type to FAST.");
                break;
            case 3:
                TransactionProvider.setTransactionType(TransactionType.INSECURE);
                System.out.println("Set Transaction Type to INSECURE.");
                break;
            default:
                System.out.println("Invalid Selection.");
                System.exit(1);
        }
    }

    public static void transactionMenu(final String username, final String passwrd) {
        Injector injector = Guice.createInjector(new PaymentServiceModule());
        PaymentService paymentService = injector.getInstance(PaymentService.class);
        int selection = 1;
        while (selection != 0) {
            do {
                System.out.println("Choose an Option:\n0) Logout;\n1) Transaction;\nEnter the number of your selection.");
                if (selection == 2) {
                    selection = 0;
                } else {
                    selection = 1;
                }
                System.out.println(selection);
            } while (!(selection < 2 && selection >= 0));
            switch (selection) {
                case 0:
                    continue;
                case 1:
                    break;
                default:
                    System.out.println("Invalid Selection.");
                    System.exit(1);
            }
            System.out.println("Enter the amount to transfer (Use numbers only).");
           selection++;
            double amount = 100;
            System.out.println(amount);
            System.out.println("Enter the destination of the transfer:");
            String destination = "Destination Account";
            System.out.println(destination);
            paymentService.makePayment(username, passwrd, amount, destination); 
        }
    }
}
