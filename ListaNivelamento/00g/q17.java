/*
 * Autor - Matheus Fagundes
 * Ultima Atualizacao - 09/08/2023
 * Objetivo - Gravar e imprimeir numeros em matriz
 */



import java.util.Scanner;

public class q17 {
    public static void main(String[] agrs){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de linhas em sequencia colunas da matriz");
        int linhas = scanner.nextInt();
        scanner.nextLine();
        int colunas = scanner.nextInt();
        scanner.nextLine();


        int[][] matrix = new int[linhas][colunas];

        System.out.println("Digite os elmentos da matriz");
        for(int i=0; i<linhas; i++){
            for(int j=0; j<colunas; j++){
                matrix[i][j] = scanner.nextInt();
                scanner.nextLine();
            }
        }

        for(int i=0; i<linhas; i++){
            for(int j=0; j<colunas; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
