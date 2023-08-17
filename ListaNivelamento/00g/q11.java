/*
 * Autor - Matheus Fagundes
 * Ultima Atualizacao - 09/08/2023
 * Objetivo - Falar a posicao do menor item
 */


import java.util.Scanner;

public class q11 {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);


        System.out.println("Digite a quantidade de elementos do array");
        int quant = scanner.nextInt();
        scanner.nextLine();

        int arrayNum[] = new int[quant];

        System.out.println("Digite os "+quant+ " elementos do array");

        for(int i=0; i<quant; i++){

            arrayNum[i] = scanner.nextInt();
            scanner.nextLine();
        }
        int menor = arrayNum[0];
        for(int i=0; i<quant; i++){
            
            if(menor > arrayNum[i]){
                menor = arrayNum[i];
            }
        }
        System.out.println(menor);

        for (int i=0; i<quant; i++){
            if(arrayNum[i] == menor){
                System.out.println("A posicao do menor item e a "+i+1);
            }
        }
    }
}
