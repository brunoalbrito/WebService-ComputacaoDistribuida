/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankconsumer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BrunoAlbuquerqueBrit
 */
public class BankConsumer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            int opcao , contaOrigem ,contaDestino, valor ;
            BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite a opção desejada"
                    + "\n 1 - Consultar saldo"
                    + "\n 2 - Fazer deposito"
                    + "\n 3 - Ralizar Transferencia"
                    + "\n 4 - Fazer um saque"
                    + "\n 0 - Zero para sair");

            try {
                opcao = Integer.parseInt(bis.readLine());
                if (opcao == 0) {
                    break;
                }
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o número da conta:\n");
                        contaOrigem = Integer.parseInt(bis.readLine());
                        break;
                    case 2:
                        System.out.println("Digite o número da conta:\n");
                        contaDestino = Integer.parseInt(bis.readLine());
                        System.out.println("Digite valor a ser depositado:\n");
                        valor = Integer.parseInt(bis.readLine());
                        break;
                    case 3:
                        System.out.println("Digite o número de origem da conta:\n");
                        contaOrigem = Integer.parseInt(bis.readLine());
                        System.out.println("Digite o número de destino da conta:\n");
                        contaDestino = Integer.parseInt(bis.readLine());
                        System.out.println("Digite valor a ser depositado:\n");
                        valor = Integer.parseInt(bis.readLine());
                        break;
                    case 4:
                        System.out.println("Digite o número da conta:\n");
                        contaOrigem = Integer.parseInt(bis.readLine());
                        System.out.println("Digite o valor que deseja sacar:\n");
                        valor = Integer.parseInt(bis.readLine());
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } catch (IOException ex) {
                Logger.getLogger(BankConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
