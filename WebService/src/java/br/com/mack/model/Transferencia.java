/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.model;

/**
 *
 * @author BrunoAlbuquerqueBrit
 */
public class Transferencia {

    private int contaOrigem;
    private int contaDestino;
    private int valor;

    public Transferencia() {
    }

    public int getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(int contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public int getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(int contaDestino) {
        this.contaDestino = contaDestino;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "contaOrigem=" + contaOrigem + ", contaDestino=" + contaDestino + ", valor=" + valor + '}';
    }

}
