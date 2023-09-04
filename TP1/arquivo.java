import java.io.*;

public class arquivo {
    public static void main(String[] args) {
        try {
            
            System.out.print("Digite o número de valores reais a serem lidos: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());

            
            RandomAccessFile file = new RandomAccessFile("valores.txt", "rw");

            
            for (int i = 0; i < n; i++) {
                System.out.print("Digite o valor real #" + (i + 1) + ": ");
                double valor = Double.parseDouble(reader.readLine());
                file.writeDouble(valor);
            }

           
            file.close();

            
            file = new RandomAccessFile("valores.txt", "r");

          
            file.seek(file.length());

            
            System.out.println("Valores lidos de trás para frente:");
            while (file.getFilePointer() > 0) {
                file.seek(file.getFilePointer() - 8);  
                double valor = file.readDouble();
                System.out.println(valor);
            }

            // Fecha o arquivo novamente
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
