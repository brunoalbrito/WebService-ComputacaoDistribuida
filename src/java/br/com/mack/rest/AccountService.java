/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rest;

import br.com.mack.model.Account;
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
    public String saldo(@PathParam("conta") int conta) {
        Account account = new Account();
        account.setNumber(conta);
        System.out.println(account);
        return "Saldo funcionando" +account.toString();
    }

    @POST
    @Path("/deposito/{conta}/{valor}")
    public String deposito(@PathParam("conta") int conta, @PathParam("valor") float valor) {
        return "Deposito funcionando";
    }

    @POST
    @Path("/transferencia/{contaOrigem}/{contaDestino}/{valor}")
    public String transferencia(@PathParam("contaOrigem") int contaOrigem,
            @PathParam("contaDestino") int contaDestino,
            @PathParam("valor") float valor) {
        return "Transferencia funcionando";
    }

    @POST
    @Path("/saque/{conta}/{valor}")
    public String saque(@PathParam("contaOrigem") int conta, @PathParam("valor") float valor) {
        return "Saque funcionando";
    }

}
