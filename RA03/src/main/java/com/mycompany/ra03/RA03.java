/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ra03;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alves
 */
public class RA03 {

    public static void main(String[] args) {
        // Criar Randomizador
        Random randomizer;
        
        // Criar Scanner para input
        Scanner scanner = new Scanner(System.in);
        
        // Menu de Seleção
        int item;
        int item2;
        
        while (true) {
            System.out.println("\nSelecione a Função Hash a ser testada:");
            System.out.println("\n (1) - Divisão");
            System.out.println("\n (2) - Multiplicação");
            System.out.println("\n (3) - Ultimos Digitos do Quadrado");
            
            item = scanner.nextInt();
            
            if (item < 1 || item > 3) {
                System.out.println("Opção invalida.");
                continue;
            }
            
            break;
        }
        
        while (true) {
            System.out.println("\nSelecione o Tamanho do Conjunto de Dados:");
            System.out.println("\n (1) - 20.000");
            System.out.println("\n (2) - 100.000");
            System.out.println("\n (3) - 500.000");
            System.out.println("\n (4) - 1.000.000");
            System.out.println("\n (5) - 5.000.000");
            
            item2 = scanner.nextInt();
            
            if (item2 < 1 || item2 > 5) {
                System.out.println("Opção invalida.");
                continue;
            }
            
            switch (item2) {
                case 1:
                    item2 = 20000;
                    break;
                case 2:
                    item2 = 100000;
                    break;
                case 3:
                    item2 = 500000;
                    break;
                case 4:
                    item2 = 1000000;
                    break;
                case 5:
                    item2 = 5000000;
                    break;
            }
            
            break;
        }
        
        
        for (int i = 0; i < 5; i++) {
            // Variaveis de Performance
            long totalInsertTime = 0;
            long totalSearchTime = 0;
            int size;
            
            switch (i) {
                case 0:
                    size = 10;
                    break;
                case 1:
                    size = 100;
                    break;
                case 2:
                    size = 1000;
                    break;
                case 3:
                    size = 10000;
                    break;
                case 4:
                    size = 100000;
                    break;
                default:
                    size = 10;
            }
            
            for (int j = 0; j < 5; j++) {
                // Inicializar Tabela e Randomizador
                HashTable tabela = new HashTable(size, "Teste", item);
                randomizer = new Random(101);
                
                // Inserção
                long insertTime = System.currentTimeMillis();
                
                for (int k = 0; k < item2; k++) {
                    int randNum = randomizer.nextInt(999999999);
                    tabela.insert(randNum);
                }
                
                insertTime = System.currentTimeMillis() - insertTime;
                
                // Busca
                long searchTime = System.nanoTime();
                
                tabela.search(991517400);
                
                searchTime = System.nanoTime() - searchTime;
                
                // Atualizar Dados
                totalInsertTime += insertTime;
                totalSearchTime += searchTime;
            }
            
            // Converter para média
            totalInsertTime = totalInsertTime / 5;
            totalSearchTime = totalSearchTime / 5;
            
            // Imprimir Resultados
            System.out.printf("\nTamanho da Tabela: %d\nTamanho do Conjunto: %d\nFunção Hash: %d\nTempo Medio de Inserção: %d ms\nTempo Medio de Busca: %d ns\n", size, item2, item, totalInsertTime, totalSearchTime);
        }
    }
}
