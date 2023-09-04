import java.util.Scanner;

public class isRecursivo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String frase = scanner.nextLine();
        while (!frase.equals("FIM")) {

            printar(isVogal(frase), isConsoante(frase), isInt(frase), isFloat(frase));
            frase = scanner.nextLine();

        }

    }

    public static boolean isVogal(String palavra) {
        if (palavra.isEmpty()) {
            return true;
        }
        if (palavra.charAt(0) == 'a' || palavra.charAt(0) == 'e' || palavra.charAt(0) == 'i' || palavra.charAt(0) == 'o'
                || palavra.charAt(0) == 'u') {
            palavra = removeInicio(palavra);
            return isVogal(palavra);
        } else
            return false;
    }

    public static String removeInicio(String palavra) {
        String novaPalavre = "";
        for (int i = 1; i < palavra.length(); i++) {
            novaPalavre += palavra.charAt(i);
        }
        return novaPalavre;
    }

    public static boolean isConsoante(String palavra) {
        if (palavra.isEmpty()) {
            return true;
        }
        if (palavra.charAt(0) < 'a' || palavra.charAt(0) > 'z' || palavra.charAt(0) == 'a' || palavra.charAt(0) == 'e'
                || palavra.charAt(0) == 'i' || palavra.charAt(0) == 'o' || palavra.charAt(0) == 'u') {
            return false;
        }
        palavra = removeInicio(palavra);
        return isConsoante(palavra);
    }

    public static boolean isInt(String numero) {
        if(numero.isEmpty()){
            return true;
        }
        if (!(numero.charAt(0) >= '0' && numero.charAt(0) <= '9')) {
            return false;
        }
        numero = removeInicio(numero);
        return isInt(numero);
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
