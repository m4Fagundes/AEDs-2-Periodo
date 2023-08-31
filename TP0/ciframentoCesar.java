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
            String sifra = "";

            for(int i=0; i<frase.length(); i++){
                if(frase.charAt(i) <'a' && frase.charAt(i) > 'z' && frase.charAt(i) <'A' && frase.charAt(i) > 'Z' && frase.charAt(i) <'0' && frase.charAt(i) > '9'){
                    sifra+= '�';
                } else
                sifra += (char)(((int)frase.charAt(i)) + key);
            }

            System.out.println(sifra);
            frase = scanner.nextLine();
        }
 
        scanner.close();
    }
}
