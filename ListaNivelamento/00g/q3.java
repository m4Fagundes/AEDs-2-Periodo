/*
 * Nome: Matheus Fagundes Araujo
 * Ultima Atualizacao: 08/08/2023
 * Objetivo:
 */


import java.util.Scanner;

public class q3 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        scanner.nextLine();
        int n2 = scanner.nextInt();
        scanner.nextLine();
        int operacao;

        if(n1 > 46 || n2 > 46){
            operacao = n1+n2;
        } else if(n1 > 20 && n2 > 20){     
            if(n1>n2) operacao = n1-n2;
            else operacao = n2=n1;
        } else if(n1<10 && n2 != 0 || n2<10 && n1 != 0){
            operacao = n1/n2;
        } else System.out.println("Matheus Fagundes");
    }
}
