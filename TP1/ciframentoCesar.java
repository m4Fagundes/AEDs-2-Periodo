/*
 * Autor - Matheus Fagundes Araujo
 * Ultima Atualizacao - 24/08/2023
 * Objetivo - Criptografia de cesar
 */


import java.util.Scanner;

public class ciframentoCesar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String frase = scanner.nextLine();
        while (!frase.equals("FIM")) {
            int key = 3;
            String cifra = "";

            for (int i = 0; i < frase.length(); i++) {
                char caracter = frase.charAt(i);

                if (caracter >= 32 && caracter <= 126) {
                    cifra += (char) (((int) caracter) + key);
                } else {
                    cifra += caracter; // Mantém o caractere inalterado
                }
            }

            System.out.println(cifra);
            frase = scanner.nextLine();
        }

        scanner.close();
    }
}
