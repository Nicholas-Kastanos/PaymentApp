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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
