/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paymentapp;

/**
 *
 * @author nicho
 */
public class InsecureTransaction implements Transaction{

    @Override
    public void makeTransaction(String username, String passwrd, double amount, String destination) {
        System.out.println("Your username " + username + " and password " + passwrd + " have been broadcast publicly.");
    }
    
}
