/*
 * Autor - Matheus Fagundes
 * Ultima Atualizacao - 09/08/2023
 * Objetivo - Somar os numeros de um arrey multiplos de 3
 */


import java.util.Scanner;

public class q14 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de elementos da lista de atrray");
        int quant = scanner.nextInt();
        scanner.nextLine();

        int[] arrayList = new int[quant];

        System.out.println("Digite os "+ quant + " itens do array");

        for(int i=0; i<quant; i++){

            arrayList[i] = scanner.nextInt();
            scanner.nextLine();

        }
        int soma=0;

        for(int i=0; i<quant; i++){
            if(arrayList[i] % 3 == 0){
                soma += arrayList[i];
            }
        }
        System.out.println("A soma dos numeros multiplos de 3 e de: "+soma);
    }
}
