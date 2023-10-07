package br.com.newtonpaiva.dominio.questao2;

import java.util.Scanner;
public class EstanteDeProdutos {
    public static void main(String[] args) {
        int[][] estante = new int[40][40]; // Matriz que representa a estante

        Scanner scanner = new Scanner(System.in);

        // Le os códigos dos produtos e armazená-los na estante
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                System.out.print("Digite o código do produto para a posição (" + i + "," + j + "): ");
                int codigoProduto = scanner.nextInt();

                if (codigoProduto >= 0 && codigoProduto <= 5) {
                    estante[i][j] = codigoProduto;
                } else {
                    System.out.println("Código de produto inválido. Use 0 para vazio ou de 1 a 5 para os produtos.");
                    j--; // Volta uma posição para tentar de novo
                }
            }
        }

        int[] quantidadeProdutos = new int[6]; // 0 representa produtos vazios

        // Conta a quantidade de cada tipo de produto na estante
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                int codigoProduto = estante[i][j];
                quantidadeProdutos[codigoProduto]++;
            }
        }

        // Imprimir a quantidade de cada tipo de produto
        System.out.println("Quantidade de caixas de produtos na estante:");
        System.out.println("Xampu: " + quantidadeProdutos[1]);
        System.out.println("Condicionador: " + quantidadeProdutos[2]);
        System.out.println("Hidratante: " + quantidadeProdutos[3]);
        System.out.println("Tintura: " + quantidadeProdutos[4]);
        System.out.println("Demaquilante: " + quantidadeProdutos[5]);
        System.out.println("Caixas vazias: " + quantidadeProdutos[0]);

        scanner.close();
    }
}