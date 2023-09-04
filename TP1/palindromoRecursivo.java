/* 
 *  Autor - Matheus Fagundes
 * Ultima Atualizacao - 03/09/2023
 * Objetivo - Identificar palindromo recursivo
*/

import java.util.Scanner;

public class palindromoRecursivo {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        
        String palavra = scanner.nextLine();

        while(!palavra.equals("FIM")){

            if(descobrePlainfromo(palavra)){
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            palavra = scanner.nextLine();
        }
    }
    
    public static boolean descobrePlainfromo(String palavra){
        int quant = palavra.length();
        if(quant == 1) {
            return true; 
        }
        if(quant == 2 && palavra.charAt(0) == palavra.charAt(quant-1)){
            return true;
        }
        if(palavra.charAt(0) == palavra.charAt(quant-1)){
            palavra = removePrimeiraEUltimString(palavra);
            return descobrePlainfromo(palavra);
        } else {
            return false;
        }
    }

    public static String removePrimeiraEUltimString(String palavra){
        String palavraOrig = "";

        for(int i=1; i<palavra.length()-1;i++){
            palavraOrig +=palavra.charAt(i);
        }
        return palavraOrig;
    }

    
}
