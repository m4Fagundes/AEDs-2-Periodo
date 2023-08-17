import java.util.Scanner;

public class q7 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        for(int i=1; i<N; i++)
        {
            if(i % 2 != 0) System.out.println(i); 
        }

    }
}
