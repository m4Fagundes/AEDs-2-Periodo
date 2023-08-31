
/*
 * Autor - Matheus Fagundes Araujo
 * Ultima Atualizacao - 24/08/2023
 * Objetivo - Mudar uma letra aleatoria em uma frase
 */
import java.util.*;

public class AlteracaoAleatoria {
    public static void main(String[] args) {
        while (true) {

            Scanner scanner = new Scanner(System.in);

            String frase = scanner.nextLine();

            if(frase.equals("FIM")) break;

            char[] randon = new char[frase.length()];
            Random gerador = new Random();
            gerador.setSeed(4);
            
            
            for(int i=0; i<frase.length(); i++){
                randon[i] = frase.charAt(i);
                if(randon[i]=='a'){
                    randon[i] = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
                }
            }
            randon.toString();
            System.out.println(randon);
            
            scanner.close();


        }
    }
}
