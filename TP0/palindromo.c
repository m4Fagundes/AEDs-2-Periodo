#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool ePalindromo(char palavra[]) {
    int inicio = 0;
    int fim = strlen(palavra) - 1;

    while (inicio < fim) {
       
        if (palavra[inicio] != palavra[fim]) {
            return false;
        }
        
        inicio++;
        fim--;
    }
    
    return true;
}

int main() {
    char palavra[100];

    while (true) {
        //printf("Digite uma palavra ou frase (ou 'FIM' para sair): ");
        fgets(palavra, sizeof(palavra), stdin);
        palavra[strcspn(palavra, "\n")] = '\0'; // Remove o caractere de nova linha (\n)

        if (strcmp(palavra, "FIM") == 0) {
            //printf("Encerrando o programa.\n");
            break;
        }

        if (ePalindromo(palavra)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }

    return 0;
}
