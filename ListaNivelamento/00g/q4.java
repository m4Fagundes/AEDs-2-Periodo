import java.util.Scanner;

public class q4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int salario = scanner.nextInt();
        scanner.nextLine();

        int prestacao = scanner.nextInt();
        scanner.nextLine();

        if(salario*4/10 > prestacao){
            System.out.println("Voce podera realizar o emprestimo");
        } else{
            System.out.println("Voce nao pode realizar o emprestimo");
        }
    }
}
