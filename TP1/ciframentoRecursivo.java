import java.util.Scanner;

public class ciframentoRecursivo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String frase = scanner.nextLine();
        while (!frase.equals("FIM")) {
            int key = 3;
            String cifra = cifrar(frase, key, 0);
            System.out.println(cifra);
            frase = scanner.nextLine();
        }

        scanner.close();
    }

    public static String cifrar(String frase, int key, int index) {
        if (index == frase.length()) {
            return "";
        }

        char caracter = frase.charAt(index);
        String cifra = "";

        if (caracter >= 32 && caracter <= 126) {
            cifra += (char) (((int) caracter) + key);
        } else {
            cifra += caracter;
        }

        return cifra + cifrar(frase, key, index + 1);
    }
}
