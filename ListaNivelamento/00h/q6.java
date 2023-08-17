import java.util.Scanner;

public class q6 {

    public static int Contador(int[] array, int tamanho) {
        int maior= array[tamanho-1];

        if (tamanho == 0) {
            return maior;
        } else {
            if(maior<array[tamanho-1]){
                maior = array[tamanho-1];
            } 
            return Contador(array, tamanho-1);
        }
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de elementos da lista de nuumeros");
        int quant = scanner.nextInt();
        scanner.nextLine();

        int[] array = new int[quant];

        System.out.println("Digite os elemento da lista");
        for(int i=0; i<quant; i++){
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }

            System.out.println("O maior numero do array e "+ Contador(array, quant));
    }
}
