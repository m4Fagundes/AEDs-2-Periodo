/*
 * Autor - Matheus Fagundes Araujo
 * Ultima Atualizacao - 24/08/2023
 * Objetivo - Criptografia de cesar
 */


import java.util.*;

public class ciframentoCesar {

    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);

            int key=3;
            String frase = scanner.nextLine();
            char[] sifra = new char[frase.length()];
            int segurador;
            
            if(frase.equals("FIM")) break;


            for(int i=0; i<frase.length(); i++){
                segurador = ((int)frase.charAt(i))+key;
                sifra[i] = (char)segurador;
            }
            sifra.toString();
            System.out.println(sifra);
            scanner.close();


        }
    }
}
