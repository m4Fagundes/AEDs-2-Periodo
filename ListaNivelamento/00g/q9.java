/*
 * Autor - Matheus Fagundes
 * Ultima Atualizacao - 09/08/2023
 * Objetivo - calculos de media em arrays 
 */


import java.util.Scanner;

public class q9 {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a nota maxima da prova");
        float notaMax = scanner.nextFloat();
        scanner.nextLine();

        float notaTot = 0.0f;
        float media = 0.0f;
        int abaixoMed = 0;
        int mediaNov = 0;
        float mediaTurma = 0.0f;
        float[] alunosNota = new float[20];

        System.out.println("Digite a nota dos 20 alunos");

        for(int i = 0; i < 20; i++){
            alunosNota[i] = scanner.nextFloat();
            notaTot += alunosNota[i];
        }
        
        mediaTurma = notaTot / 20;
        media = (6 * notaMax) / 10;
        
        for(int i = 0; i < 20; i++){
            if(alunosNota[i] < media) {
                abaixoMed++;
            } else if(alunosNota[i] > (8 * notaMax) / 10) {
                mediaNov++;
            }
        }
        
        System.out.println("Média da turma: " + mediaTurma);
        System.out.println("Alunos abaixo da média: " + abaixoMed);
        System.out.println("Alunos com nota acima de 80%: " + mediaNov);
    }
}
