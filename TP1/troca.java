import java.util.Random;
import java.util.Scanner;

public class troca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random gerador = new Random();
        gerador.setSeed(4);
        String entrada = scanner.nextLine();

        while (!entrada.equals("FIM")) {
            //System.out.print("Digite uma frase (ou 'FIM' para encerrar): ");
            


            char letra1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            char letra2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            String resultado = substituirLetra(entrada, letra1, letra2);
            System.out.println(resultado);
            entrada = scanner.nextLine();
        }

        scanner.close();
    }

    public static String substituirLetra(String texto, char letra1, char letra2) {
        char[] caracteres = texto.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] == letra1) {
                caracteres[i] = letra2;
            }
        }
        return new String(caracteres);
    }
}
