/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paymentapp;

import java.util.Scanner;

/**
 *
 * @author nicho
 */
public class SecureTransaction implements Transaction{

    @Override
    public void makeTransaction(String username, String passwrd, double amount, String destination) {
        System.out.println(amount + " is to be transfered to " + destination + "\nPlease re-enter your password to continue: ");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextLine().equals(passwrd)){
            System.out.println("Transfer Successful!");
        } else {
            System.out.println("Transfer Failed!");
        }
    }
    
}
