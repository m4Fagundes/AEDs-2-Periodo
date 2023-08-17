/*
 * Autor - Matheus Fagundes
 * Ultima Atualizacao - 11/08/2023
 * Objetiv - Criacao da classe retangulo
 */

import java.util.Scanner;

    class Retangulo{
    private int base;
    private int altura;

    Retangulo(){
        inicializar(1,1);
    }
    Retangulo(int nBase, int nAltura){
        inicializar(nBase, nAltura);
    }
    public void inicializar(int nBase, int nAltura){
        setAltura(nAltura);
        setBase(nBase);
    }

    Scanner scanner = new Scanner(System.in);

    public void setBase(int nBase){
        boolean controlador = true;

        while(controlador){
            if(nBase <0){
                System.out.println("Valor invalido digite uma base valida");
                nBase = scanner.nextInt();
                scanner.nextLine();
            } else{
                base = nBase;
                controlador = false;
            }
            
        }
    }
    public void setAltura(int nAltura){
        boolean controlador = true;

        while(controlador){
            
            if(nAltura < 0){
                System.out.println("Valor invalido, digite um novo valor valido");
                nAltura = scanner.nextInt();
                scanner.nextLine();
            } else{
                altura = nAltura;
                controlador = false;
            }
        }
    }

    public int getAltura(){ return altura; }
    public int getBase(){ return base; }
    public int getArea(){ return base*altura; }
    public int getPerimetro(){ 
        int perimetro;
        perimetro = base + base + altura + altura;
        return perimetro;
    }
    public double getDiagonal() {
        return Math.sqrt((base*base)+(altura*altura));
    }
}


public class q1 {   
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a base do retangulo, em sequencia a altura");
        int base = scanner.nextInt();
        scanner.nextLine();
        int altura = scanner.nextInt();
        scanner.nextLine();

        Retangulo retangulo = new Retangulo();
        retangulo.inicializar(base, altura);

        System.out.println("A area do retangulo e "+retangulo.getArea()+" e a diagonal e "+ retangulo.getDiagonal());
        
        

    }
}
