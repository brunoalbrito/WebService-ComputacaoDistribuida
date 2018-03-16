/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author BrunoAlbuquerqueBrit
 */
@Path("")
public class AccountService {
    
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/saldo/{conta}")
    public String saldo(){
        return "Saldo funcionando";
    }
    
    @POST
    @Path("/deposito/{conta}/{valor}")
    public String deposito(){
        return "Deposito funcionando";
    }
    
    @POST
    @Path("/transferencia/{contaOrigem}/{contaDestino}/{valor}")
    public String transferencia(){
        return "Transferencia funcionando";
    }
    
    @POST
    @Path("/saque/{conta}/{valor}")
    public String saque(){
        return "Saque funcionando";
    }
    
}
