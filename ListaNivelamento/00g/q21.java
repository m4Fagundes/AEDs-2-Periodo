/*
 * Autor - Matheus Fagundes Araujo
 * Ultima atualizacao - 10/08/2023
 * Objetivo - Media da matriz
 */

import java.util.Scanner;

public class q21 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de linhas em squencia colunas");

        int linhas = scanner.nextInt();
        scanner.nextLine();
        int coluna = scanner.nextInt();
        scanner.nextLine();
        int soma=0, media;

        int[][] matrix = new int[linhas][coluna];

        System.out.println("Digite os elementos da matriz");

        for(int i=0; i<linhas; i++){
            for(int j=0; j<coluna; j++){
                matrix[i][j] = scanner.nextInt();
                scanner.nextLine();
            }
        }

        for(int i=0; i<linhas; i++){
            for(int j=0; j<coluna; j++){
                soma += matrix[i][j];
            }
        }

        media = (soma /(linhas*coluna));
        System.out.println("A media dos elementos da matriz e: "+media);

    }
}   
