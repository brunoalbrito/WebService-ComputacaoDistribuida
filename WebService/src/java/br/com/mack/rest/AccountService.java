/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rest;

import br.com.mack.model.Account;
import br.com.mack.model.Transferencia;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
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
@Singleton
@Path("")
public class AccountService {

    private final ArrayList<Account> accounts = new ArrayList<>();

    public AccountService() {
        for (int i = 0; i < 10; i++) {
            accounts.add(new Account(i, 1000));
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/saldo/{conta}")
    public String saldo(@PathParam("conta") int conta) {
        JsonObject object = new JsonObject();
        object.addProperty("saldo", String.valueOf(accounts.get(conta).getSaldo()));
        return object.toString();
    }

    @POST
    @Path("/deposito")
    @Consumes(MediaType.APPLICATION_JSON)
    //public void deposito(@PathParam("conta") int conta, @PathParam("valor") int valor) {
    public String deposito(String valores) {
        Gson g = new Gson();
        Account account = g.fromJson(valores, Account.class);
        System.out.println(account);

        //System.out.println(valores);
        Account a = accounts.get(account.getNumero());

        if (a.deposito(account.getSaldo())) {
            accounts.set(account.getNumero(), a);
            System.out.println(accounts.get(account.getNumero()));
            return "Operacao realizada com sucesso";
        }

        return "Falha na operacao";
    }

    @POST
    @Path("/transferencia")
    @Consumes(MediaType.APPLICATION_JSON)
    public String transferencia(String valores) {
        Gson g = new Gson();
        Transferencia transferencia = g.fromJson(valores, Transferencia.class);
        System.out.println(transferencia);

        if (accounts.get(transferencia.getContaOrigem()).getSaldo() >= transferencia.getValor()) {
            Account contaOrigem = accounts.get(transferencia.getContaOrigem());
            Account contaDestino = accounts.get(transferencia.getContaDestino());

            if (contaOrigem.getSaldo() >= transferencia.getValor()) {
                contaOrigem.saque(transferencia.getValor());
                contaDestino.deposito(transferencia.getValor());

                accounts.set(transferencia.getContaOrigem(), contaOrigem);
                accounts.set(transferencia.getContaDestino(), contaDestino);

                return "Operacao realizada com sucesso";
            }
        }

        return "Falha na operacao";
    }

    @POST
    @Path("/saque")
    @Consumes(MediaType.APPLICATION_JSON)
    public String saque(String valores) {

        Gson g = new Gson();
        Account account = g.fromJson(valores, Account.class);
        System.out.println(account);

        //System.out.println(valores);
        Account a = accounts.get(account.getNumero());
        if (a.getSaldo() >= account.getSaldo()) {
            a.saque(account.getSaldo());
            accounts.set(account.getNumero(), a);
            System.out.println(accounts.get(account.getNumero()));
            System.out.println("Saque funcion");
            return "Operacao realizada com sucesso";
        }

        return "Falha na operacao";
    }

}
