import java.io.*;

public class arquivo1 {
    public static void main(String[] args) {
        try {
            // Cria o arquivo para escrita
            RandomAccessFile arquivo = new RandomAccessFile("numeros.txt", "rw");

            // Solicita ao usuário a quantidade de números a serem digitados
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Quantidade de números a serem digitados: ");
            int n = Integer.parseInt(br.readLine());

            // Lê e salva os números no arquivo
            for (int i = 0; i < n; i++) {
                //System.out.print("Digite um número: ");
                double numeroDigitado = Double.parseDouble(br.readLine());

                // Escreve o número no arquivo
                arquivo.writeDouble(numeroDigitado);
            }

            // Fecha o arquivo
            arquivo.close();

            // Abre o arquivo novamente para leitura
            arquivo = new RandomAccessFile("numeros.txt", "r");
            
            long fileSize = arquivo.length();
            arquivo.seek(fileSize - 8); // Subtrai 8 bytes para posicionar antes do último número

            // Lê e imprime o último número
            double ultimoNumero = arquivo.readDouble();
            System.out.println(ultimoNumero);

            // Move o ponteiro para o número anterior
            arquivo.seek(fileSize - 16); // Subtrai 16 bytes para posicionar antes do penúltimo número

            // Lê e imprime os números restantes de trás para frente
            while (arquivo.getFilePointer() >= 8) { // Verifica se ainda há pelo menos 8 bytes para ler
                double numeroLido = arquivo.readDouble();
                System.out.println(numeroLido);

                // Move o ponteiro para o número anterior
                arquivo.seek(arquivo.getFilePointer() - 16); // Subtrai 16 bytes para posicionar antes do número anterior
            }

            // Fecha o arquivo novamente
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter número: " + e.getMessage());
        }
    }
}
