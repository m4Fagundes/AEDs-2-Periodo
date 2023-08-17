/*
 * Nome: Matheus Fagundes Araujo
 * Ultima Atualizacao: 08/08/2023
 * Objetivo: buscar elementos de um array
 */

 import java.util.Scanner;

 public class q1{
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);


        System.out.println("Digite a quantidade de numeros da lista de array");
        
        int controlador = 0;
        int quant = scanner.nextInt();
        scanner.nextLine();
        int[] listaNum = new int[quant];

        for(int i=0; i<quant; i++){
            listaNum[i] = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Digite um numero que deseja verificar se esta prersente no array list");

        int numeroVerificar = scanner.nextInt();
        scanner.nextLine();

        for(int i=0; i<quant; i++){
            
            if(listaNum[i] == numeroVerificar){
                controlador = 1;
            }
        }
        if(controlador == 1){
            System.out.println("O numero esta presente no array");
        } else {
            System.out.println("O numero nao esta presente no array");
        }
    }
 }