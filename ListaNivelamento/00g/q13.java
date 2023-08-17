/*
 * Autor - Matheus Fagundes
 * Ultima Atualizacao - 09/08/2023
 * Objetivo - Somar o primeiro com o ultimo antepenultimo com o segundo...
 */


import java.util.Scanner;

public class q13 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de elementos que deseja no seu arrey");
        int quant = scanner.nextInt();
        scanner.nextLine();
        int[] arrayNum = new int[quant];

        System.out.println("Digite os "+ quant +" elementos do array");

        for(int i=0; i<quant; i++){
            arrayNum[i] = scanner.nextInt();
            scanner.nextLine();
        }

        int soma=0;


        for(int i=0; i<quant/2; i++){
            soma = arrayNum[i] + arrayNum[quant-i-1];
            System.out.println("Soma: "+soma);

        }

    }
}
