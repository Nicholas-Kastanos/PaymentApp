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
public interface Transaction {
    public void makeTransaction(final String username, final String passwrd, final double amount, final String destination);
}
