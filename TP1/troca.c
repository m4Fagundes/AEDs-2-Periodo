#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

void substituirLetra(char *texto, char letra1, char letra2) {
    for (int i = 0; texto[i] != '\0'; i++) {
        if (texto[i] == letra1) {
            texto[i] = letra2;
        }
    }
}

int main() {
    srand(time(NULL));

    while (1) {
       char entrada[100];
        fgets(entrada, sizeof(entrada), stdin);

        if (strncmp(entrada, "FIM", 3) == 0) {
            break;
        }

        char letra1 = 'a' + (rand() % 26);
        char letra2 = 'a' + (rand() % 26);

        substituirLetra(entrada, letra1, letra2);
        printf("%s", entrada);
    }

    return 0;
}
