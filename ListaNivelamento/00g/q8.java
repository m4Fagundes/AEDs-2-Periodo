import java.util.Scanner;

public class q8 {
    public static void main(String[] srgs){
        
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();
        int i=1;
        boolean controlador = true;

        while (i<N) {
            
            System.out.println(i);

            if(controlador){
                i+=4;
                controlador = false;
            } else{
                i+=7;
                controlador = true;
            }
            
        }

    }
}

