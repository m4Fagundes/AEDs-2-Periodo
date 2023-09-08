import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LerArquivoDeTrasParaFrente {
    public static void main(String[] args) {
        List<Double> numeros = new ArrayList<>();

        try {
            // Abre o arquivo para leitura
            RandomAccessFile arquivo = new RandomAccessFile("exemplo.txt", "r");

            // Move o ponteiro para o final do arquivo
            long fileSize = arquivo.length();
            arquivo.seek(fileSize - 8); // Subtrai 8 bytes para pular o último número (double)

            // Lê os números do arquivo de trás para frente
            while (arquivo.getFilePointer() >= 8) {
                double valor = arquivo.readDouble();
                numeros.add(valor);

                // Move o ponteiro para o número anterior
                arquivo.seek(arquivo.getFilePointer() - 16); // Subtrai 16 bytes para pular dois números (double)
            }

            // Imprime os números de trás para frente
            Collections.reverse(numeros);
            for (Double numero : numeros) {
                System.out.println("Número lido: " + numero);
            }

            // Fecha o arquivo
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
