/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author BrunoAlbuquerqueBrit
 */
@Path("")
public class AccountService {
    
    
    @GET
    public String saldo(){
        return "Saldo funcionando";
    }
    
    @POST
    public String deposito(){
        return "Deposito funcionando";
    }
    
    @POST
    public String transferencia(){
        return "Transferencia funcionando";
    }
    
    @POST
    public String saque(){
        return "Saque funcionando";
    }
    
}
