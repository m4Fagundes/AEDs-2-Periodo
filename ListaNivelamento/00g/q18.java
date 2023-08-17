/*
 * Autor - Matheus Fagundes 
 * Ultima atualizacao 10/08/2023
 * Objetivo - Mostrar a matriz transposta
 */



import java.util.Scanner;

public class q18 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de linhas em sequência colunas da matriz");
        int linhas = scanner.nextInt();
        scanner.nextLine();
        int colunas = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[linhas][colunas];
        int[][] transposta = new int[colunas][linhas];

        System.out.println("Digite os elementos da matriz");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matrix[i][j] = scanner.nextInt();
                scanner.nextLine();
            }
        }

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                transposta[j][i] = matrix[i][j];
            }
        }

        System.out.println("Matriz Original:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatriz Transposta:");
        for (int i = 0; i < colunas; i++) { 
            for (int j = 0; j < linhas; j++) {
                System.out.print(transposta[i][j] + " ");
            }
            System.out.println();
        }
    }
}
