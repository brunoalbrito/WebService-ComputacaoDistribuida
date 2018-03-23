/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rest;

/**
 *
 * @author BrunoAlbuquerqueBrit
 */
public interface InterfaceBanco {
    public void deposito(int conta, int valor);
    
    public void saque(int conta, int valor);
    
    public void transferencia(int conta_orig, int conta_dest, int valor);
    
    public String saldo(int conta);
}
