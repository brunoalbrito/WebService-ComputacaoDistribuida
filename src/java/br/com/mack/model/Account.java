/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.model;

import java.io.Serializable;

/**
 *
 * @author BrunoAlbuquerqueBrit
 */
public class Account implements Serializable{
    private int number;
    private float balance;

    public Account() {
    }

    public Account(int number, float balance) {
        this.number = number;
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" + "number=" + number + ", balance=" + balance + '}';
    }
    
}
