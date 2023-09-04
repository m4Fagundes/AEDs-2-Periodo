/*
 * Autor - Matheus Fagundes Araujo
 * Ultima Atualizacao - 04/09/2023
 * Objetivo - uma sequencia linear de numeros espelhada pelo contrario dela no final
 */

import java.util.Scanner;

public class warmUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        while (contador != 3) {
            //System.out.print("Digite o valor inicial: ");
            int comecar = scanner.nextInt();
            //System.out.print("Digite o valor final: ");
            int ate = scanner.nextInt();
            scanner.nextLine();

            String sequencia = gravaSequencia(comecar, ate);
            System.out.print(sequencia);
            String sequenciaInvertida = inverteSequencia(sequencia);
            System.out.println(sequenciaInvertida);

            contador++;
        }
    }

    public static String gravaSequencia(int comecar, int ate) {
        StringBuilder sequencia = new StringBuilder();
        for (int i = comecar; i <= ate; i++) {
            sequencia.append(i);
        }
        return sequencia.toString();
    }

    public static String inverteSequencia(String sequencia) {
        StringBuilder sequenciaInvertida = new StringBuilder(sequencia);
        return sequenciaInvertida.reverse().toString();
    }
}
