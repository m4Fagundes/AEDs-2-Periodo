/*
 * Autor - Matheus Fagundes
 * Ultima Atualizacao - 09/08/2023
 * Objetivo - Intercalar 2 vetores
 */


import java.util.Scanner;

public class q16 {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de elementos do vetor 1");
        int quant1 = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Digite a quantidade de elementos do vetor 2");
        int quant2 = scanner.nextInt();
        scanner.nextLine();

        int[] vet1 = new int[quant1];
        int[] vet2 = new int[quant2];
        int quantMaior;


        System.out.println("Digite os elementos do primeiro vetor");

        for(int i=0; i<quant1; i++){
            vet1[i] = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Digite os elementos do segundo vetor");

        for(int i=0; i<quant2; i++){
            vet2[i] = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("O vetor intercalado e");

        if(quant1>quant2){
            quantMaior = quant1;
        } else{
            quantMaior = quant2;
        }

        for(int i=0; i<quantMaior; i++){
            System.out.println(vet1[i] + " " + vet2[i]);
        }
    }
}
