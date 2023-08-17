/*
 * Autor - Matheus Fagundes
 * Ultima Atualizacao - 09/08/2023
 * Objetivo - Contar quantos elementos sao pares e quantos divisiveis por 3 em um arruy de numeros
 */


import java.util.Scanner;

public class q12 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de elementos que deseja no seu arrey");
        int quant = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite os "+ quant +" elementos do array");
        int[] arrayNum = new int[quant];
        int pares=0, divisiveis3=0;

        for(int i=0; i<quant; i++){
            arrayNum[i] = scanner.nextInt();
            scanner.nextLine();
        }

        for(int i=0; i<quant; i++){
            if(arrayNum[i] % 2 ==0){
                pares++;
            }
            if(arrayNum[i] % 3 ==0){
                divisiveis3++;
            }
        }
        System.out.println("A quantidade de numeros pares e de "+pares+" e a de numeros divisiveis por 3 e "+divisiveis3);
        
    }
}
