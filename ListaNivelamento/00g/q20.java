/*
 * Autor - Matheus Fagundes Araujo
 * Ultima atualizacao - 10/08/2023
 * Objetivo - Mostrar a diagonal principal e a secundaria
 */

import java.util.Scanner;

public class q20 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de linhas//colinas da matriz");
        int quant = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[quant][quant];

        System.out.println("Digite os elementos da matriz");


        for(int i=0; i<quant; i++){
            for(int j=0; j<quant; j++){
                matrix[i][j] = scanner.nextInt();
                scanner.nextLine();
            }
        }

        System.out.println("A diagonal principal e ");

        for(int i=0; i<quant; i++){
            for(int j=0; j<quant; j++){
                if(i == j){
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }

        System.out.println("A diagonal secundaria e:");

        for(int i=0; i<quant; i++){
            for(int j=0; j<quant; j++){
                if(i + j == quant-1){
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
        
    }
}
