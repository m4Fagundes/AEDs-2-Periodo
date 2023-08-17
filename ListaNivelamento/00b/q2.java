/* 
 * Autor - Matheus Fagundes
 * Ultima Atualizacao - 08/08/2023
 * Objetivo - Identificar o maior e o menor elemento do array
*/

import java.util.Scanner;

public class q2 {
    public static void main(String[] agrs){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de numero que deseja armazenar no array");
        int quant = scanner.nextInt();
        scanner.nextLine();

        int maior, menor;

        int[] listaNum = new int[quant];

        System.out.println("Digite os "+ quant + " numeros");

        for(int i=0; i < quant; i++){

            listaNum[i] = scanner.nextInt();
            scanner.nextLine();
        }
        maior = listaNum[0];
        menor = listaNum[0];
        for(int i=0; i < quant; i++){
            if(listaNum[i] > maior) maior = listaNum[i];
            if(listaNum[i] < menor) menor = listaNum[i];
        }

        System.out.println("Maior numeor e: " + maior + " e o menor e: " + menor);
    }
}
