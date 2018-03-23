/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rest;

import br.com.mack.model.Account;
import com.google.gson.JsonObject;
import java.util.ArrayList;
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
public class AccountService implements InterfaceBanco {

    private final ArrayList<Account> accounts = new ArrayList<>();

    public AccountService() {
        for (int i = 0; i < 10; i++) {
            accounts.add(new Account(i, 1000));
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/saldo/{conta}")
    @Override
    public String saldo(@PathParam("conta") int conta) {
        JsonObject object = new JsonObject();
        object.addProperty("saldo", String.valueOf(accounts.get(conta).getSaldo()));
        return object.toString();
    }

    @POST
    @Path("/deposito/{conta}/{valor}")
    public void deposito(@PathParam("conta") int conta, @PathParam("valor") int valor) {
        accounts.get(conta).setSaldo(accounts.get(conta).getSaldo() + valor);
    }

    @POST
    @Path("/transferencia/{contaOrigem}/{contaDestino}/{valor}")
    public void transferencia(@PathParam("contaOrigem") int conta_origem,
            @PathParam("contaDestino") int conta_destino,
            @PathParam("valor") int valor) {
//        return "Transferencia funcionando";
    }

    @POST
    @Path("/saque/{conta}/{valor}")
    public void saque(@PathParam("contaOrigem") int conta, @PathParam("valor") int valor) {
        System.out.println("Saque funcion");
//        return "Saque funcionando";
    }

}
