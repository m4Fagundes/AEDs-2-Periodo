/*
 * Nome: Matheus Fagundes Araujo
 * Ultima Atualizacao: 08/08/2023
 * Objetivo: 
 */

import java.util.Scanner;

public class q5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os 2 numeros");

        double n1 = scanner.nextDouble();
        double n2 = scanner.nextDouble();
        double cubica;
        double log;

        if(n1 > n2){
            cubica = Math.cbrt(n2);
            log = Math.log(n2) / Math.log(n1);
        } else{
            cubica = Math.cbrt(n1);
            log = Math.log(n1) / Math.log(n2);
        }
        System.out.println("Raiz "+ cubica + " Log " + log);
    }
}
