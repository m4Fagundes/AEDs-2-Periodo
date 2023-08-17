/*
 * Autor - Matheus Fagundes
 * Ultima atualizacao - 11/08/2023
 * Objetivo - Somas sequentes recursivas
 */

import java.util.Scanner;

public class q5 {


    public class Contador{
        public static int cont(int n1){
            if(n1 == 0){
                return 0;
            } else if(n1 > 0){
                return 1 + cont(n1-1);
            } else { return -1; }
        }
    }
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor que deseja somar");
        int a = scanner.nextInt();
        scanner.nextLine();

        
        System.out.println("O resultado e: "+Contador.cont(a));

    }
}
