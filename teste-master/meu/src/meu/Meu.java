package meu;

import java.util.*;

class Meu {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static int soma(int num1, int num2) {
		return num1 + num2;
	}
	
	public static void main(String[] args) {
		int num1= 0, num2 = 0;
		System.out.println("Digite um numero: ");
		num1 = sc.nextInt();
		System.out.println("Digite outro numero: ");
		num2 = sc.nextInt();
		System.out.println(soma(num1,num2));
		sc.close();
	}

}
