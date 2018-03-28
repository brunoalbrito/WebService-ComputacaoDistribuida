/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rest;

import br.com.mack.model.Account;
import java.util.Map;

/**
 *
 * @author BrunoAlbuquerqueBrit
 */
public interface InterfaceBanco {
    public void deposito(String valores);
    
    public void saque(int conta, int valor);
    
    public void transferencia(int conta_orig, int conta_dest, int valor);
    
    public String saldo(int conta);
}
