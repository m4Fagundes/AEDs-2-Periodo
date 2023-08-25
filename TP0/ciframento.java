/*
 * Autor - Matheus Fagundes Araujo
 * Ultima Atualizacao - 24/08/2023
 * Objetivo - Criptografia de cesar
 */

import java.util.Scanner;

public class ciframento {
    public static void main(String[] rags) {

        Scanner scanner = new Scanner(System.in);
        boolean controlador = true;

        while (controlador) {
            String frase = scanner.nextLine();
            char[] novoArray = new char[frase.length()];
            int caractere;

            if (frase.equals("FIM"))
                break;

            for (int i = 0; i < frase.length(); i++) {
                caractere = frase.charAt(i);
                novoArray[i] = descola3(caractere);

            }

            String resultado = new String(novoArray);
            System.out.println(resultado);
            scanner.close();
        }
    }

    public static char descola3(int c) {
        c += 3;
        char ch = (char) c;
        return ch;
    }
}