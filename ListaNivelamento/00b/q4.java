public class q4 {
    public static void main(String[] args) {
        String input = "ExampleString";
        boolean result = isConsoanete(input, 0);
        System.out.println(result);
    }

    public static boolean isConsoanete(String s, int n) {
        if (n == s.length()) {
            return true;  // Se n chegou ao final da string, todos os caracteres foram verificados, então retorna true.
        } else {
            if (s.charAt(n) < '0' || s.charAt(n) > '9') {  // Verifica se o caractere atual não é um dígito.
                if (s.charAt(n) == 'A' || s.charAt(n) == 'E' || s.charAt(n) == 'I' || s.charAt(n) == 'O' || s.charAt(n) == 'U' || s.charAt(n) == 'a' || s.charAt(n) == 'e' || s.charAt(n) == 'i' || s.charAt(n) == 'o' || s.charAt(n) == 'u') {
                    return false;  // Se o caractere atual for uma vogal (maiúscula ou minúscula), retorna false.
                } else {
                    n++;  // Incrementa n para verificar o próximo caractere.
                    return isConsoanete(s, n);  // Chama a função recursivamente com o próximo caractere.
                }
            } else {
                return false;  // Se o caractere atual for um dígito, retorna false.
            }
        }
    }
}
