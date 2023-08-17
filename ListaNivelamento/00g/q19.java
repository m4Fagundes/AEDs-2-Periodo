/*
 * Autor - Matheus Fagundes 
 * Ultima atualizacao 10/08/2023
 * Objetivo - Somar matrizes
 */

 import java.util.Scanner;

public class q19 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);


        System.out.println("Digite a quantidade de linhas em sequencia colunas: ");
        
        int linhas = scanner.nextInt();
        scanner.nextLine();

        int colunas = scanner.nextInt();
        scanner.nextLine();
        
        int[][] matrix1 = new int[linhas][colunas];
        int[][] matrix2 = new int[linhas][colunas];
        int[][] resultante = new int[linhas][colunas];

        System.out.println("Digite os elementos da primeira matriz: ");

        for(int i=0; i<linhas; i++){
            for(int j=0; j<colunas; j++){
                matrix1[i][j] = scanner.nextInt();
                scanner.nextLine();
            }
        }

        System.out.println("Digite os elementos da segundo matriz: ");

        for(int i=0; i<linhas; i++){
            for(int j=0; j<colunas; j++){
                matrix2[i][j] = scanner.nextInt();
                scanner.nextLine();
            }
        }
        System.out.println("A metriz resultant e");

        for(int i=0; i<linhas; i++){
            for(int j=0; j<colunas; j++){
                resultante[i][j] = matrix1[i][j] + matrix2[i][j];
            } 
        }

        for(int i=0; i<linhas; i++){
            for(int j=0; j<linhas; j++){
                System.out.print(resultante[i][j]+" ");
            }
            System.out.println();
        }
    }
}
