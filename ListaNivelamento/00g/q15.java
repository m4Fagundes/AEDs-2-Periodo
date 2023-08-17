/*
 * Autor - Matheus Fagundes
 * Ultima Atualizacao - 09/08/2023
 * Objetivo - Intercalar 2 vetores
 */

import java.util.Scanner;

public class q15 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de elementos dos 2 vetores que deseja intercalar");
        int quant = scanner.nextInt();
        scanner.nextLine();

        int[] vet1 = new int[quant];
        int[] vet2 = new int[quant];

        System.out.println("Digite os numeros do 1 vetor");
        for(int i=0; i<quant; i++){
            vet1[i] = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Digite os numeros do 2 vetor");
        for(int i=0; i<quant; i++){
            vet2[i] = scanner.nextInt();
            scanner.nextLine();
        }

        for(int i=0; i<quant; i++){
            System.out.print(vet1[i]+" "+ vet2[i]+" ");
        }
    }    
}
