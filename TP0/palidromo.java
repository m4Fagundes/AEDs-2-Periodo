/*
 * Autor - Matheus Fagundes Araujo
 * Ultima Atualizacao - 24/08/2023
 * Objetivo - criar um metodo que identifique palindromos
 */

import java.util.Scanner;

public class palidromo {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            //System.out.println("Digite uma palavra (ou 'FIM' para sair): ");
            String palavra = scanner.nextLine();

            if (palavra.replaceAll("\\s+", "").equalsIgnoreCase("FIM")) {
                //System.out.println("Encerrando o programa.");
                break; 
            }

            if (ePalindromo(palavra)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
        }
        scanner.close();
    }

    public static boolean ePalindromo(String palavra) {
        StringBuilder palavraI = new StringBuilder(palavra);
        palavraI.reverse();
        return palavra.equals(palavraI.toString());
    }
}