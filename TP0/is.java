/*
 * Autor - Matheus Fagundes
 * Ultima Atualizacao 31/08/2023
 * Objetivo - Verificar se a frase e compasta so de consoantes ou vogais e ver se e um int ou float
 */


import java.util.Scanner;

public class is {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String frase = scanner.nextLine();

        while(!frase.equals("FIM")){

            printar(isVogal(frase), isConsoante(frase), isInt(frase), isFloat(frase));
            frase = scanner.nextLine();
            
        }

    }

    public static boolean isVogal(String palavra) {
        for (int i = 0; i < palavra.length(); i++) {
            char c = Character.toLowerCase(palavra.charAt(i));
            if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isConsoante(String palavra) {
        for (int i = 0; i < palavra.length(); i++) {
            char c = Character.toLowerCase(palavra.charAt(i));
            if (c < 'a' || c > 'z' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return false;
            }
        }
        return true;
    }

    public static boolean isInt(String numero) {
        for (int i = 0; i < numero.length(); i++) {
            if (!(numero.charAt(i) >= '0' && numero.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFloat(String numero) {
        int contadorVirgola = 0;
        for (int i = 0; i < numero.length(); i++) {
            char c = numero.charAt(i);
            if (c == '.') {
                contadorVirgola++;
            } else if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return contadorVirgola == 1; 
    }

    public static void printar(boolean valor1, boolean valor2, boolean valor3, boolean valor4) {
        if (valor1) {
            System.out.print("SIM ");
        } else {
            System.out.print("NAO ");
        }
        if (valor2) {
            System.out.print("SIM ");
        } else {
            System.out.print("NAO ");
        }
        if (valor3) {
            System.out.print("SIM ");
        } else {
            System.out.print("NAO ");
        }
        if (valor4) {
            System.out.print("SIM ");
        } else {
            System.out.print("NAO ");
        }
        System.out.println();
    }
}
