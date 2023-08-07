import java.util.Scanner;

public class palindromo {
    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(System.in);
 
        String palavra = scanner.nextLine();
        StringBuilder palavraInvertida = new StringBuilder();
        int quant = palavra.length();

        for (int i = quant - 1; i >= 0; i--) {
            palavraInvertida.append(palavra.charAt(i));
        }

        if (palavra.equals(palavraInvertida.toString())) {
            System.out.println("E um palindromo");
        } else{
            System.out.println("Nao e um palindromo");
        }
    }
}
