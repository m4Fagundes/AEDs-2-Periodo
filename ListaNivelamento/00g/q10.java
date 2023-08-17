/*
 * Autor - Matheus Fagundes
 * Ultima Atualizacao - 09/08/2023
 * Objetivo - somar o 1 com o 2, 3 com o 4.... (elementos do array)
 */


import java.util.Scanner;

public class q10 {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de numeros do array");
        int quant = scanner.nextInt();
        scanner.nextLine();

        int[] numeros = new int[quant];
        

        for(int i =0; i<quant; i++){
            numeros[i] = scanner.nextInt();
            scanner.nextLine();
        }
        int aux1, aux2;
        int aux=0;
        for(int i =0; i<quant; i++){

            if(quant % 2 == 0){
                aux1 = numeros[i+aux];
                aux2 = numeros[i+1+aux];
                System.out.println(aux1 + aux2);
                aux++;
            }
        }
    }
}
