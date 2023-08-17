import java.util.Scanner;


public class q3 {

    public static class RecursiveMultiplication {
        public static int multiply(int a, int b) {
            if (b == 0) {
                return 0;
            } else if(b > 0) {
                return a + multiply(a, b - 1);
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        System.out.println("Digite os numeros que deseja multiplicar");
        
        int a = scanner.nextInt();
        scanner.nextLine();
        int b = scanner.nextInt();
        scanner.nextLine();

        int result = RecursiveMultiplication.multiply(a, b); 
        System.out.println(a + " * " + b + " = " + result);
        
        scanner.close();
    }
}