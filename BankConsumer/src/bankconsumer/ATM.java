/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankconsumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BrunoAlbuquerqueBrit
 */
public class ATM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String maquina = args[0];
        String porta = args[1];
        String operacao = args[2];
        int conta, valor, contaOrigem, contaDestino;

        switch (operacao) {
            case "saldo":
                System.out.println("Saldo");
                conta = Integer.parseInt(args[3]);
                System.out.println(conta);
                consultarSaldo(maquina, porta, conta);
                break;
            case "deposito":
                System.out.println("Deposito");
                conta = Integer.parseInt(args[3]);
                valor = Integer.parseInt(args[4]);
                System.out.println("Deposito");
                fazerDeposito(maquina, porta, conta, valor);
                break;
            case "transferencia":
                contaOrigem = Integer.parseInt(args[3]);
                contaDestino = Integer.parseInt(args[4]);
                valor = Integer.parseInt(args[5]);
                System.out.println("Transferencia");
                fazerTransferencia(maquina, porta, contaOrigem, contaDestino, valor);
                break;
            case "saque":
                System.out.println("Saque");
                conta = Integer.parseInt(args[3]);
                valor = Integer.parseInt(args[4]);
                System.out.println(conta);
                System.out.println(valor);
                break;
        }
    }

    public static void consultarSaldo(String maquina, String porta, int conta) {
        String host = "http://" + maquina + ":" + porta + "/WebService/bank/saldo/" + conta;
        try {
            URL url = new URL(host);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println("A conta " + conta + " possui " + response.toString().
                        replace("{", "").replace("}", "").
                        replace("\"", "").
                        replace(":", " de ") + " reais");
            } else {
                System.out.println("GET request not worked");
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void fazerDeposito(String maquina, String porta, int conta, int valor) {
        String host = "http://" + maquina + ":" + porta + "/WebService/bank/deposito";
        URL url;
        try {
            url = new URL(host);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            String query = "{\"numero\":\"" + conta + "\", \"saldo\" : \"" + valor + "\"}";
            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(query);
            wr.flush();

            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response);
            } else {
                System.out.println("GET request not worked");
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void fazerTransferencia(String maquina, String porta, int contaOrigem, int contaDestino, int valor) {
        String host = "http://" + maquina + ":" + porta + "/WebService/bank/transferencia";
        URL url;
        try {
            url = new URL(host);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            String query = "{\"contaOrigem\": \"" + contaOrigem + "\",\"contaDestino\": \"" + contaDestino + "\",\"valor\": \"" + valor + "\"}";
            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(query);
            wr.flush();

            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response);
            } else {
                System.out.println("GET request not worked");
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
