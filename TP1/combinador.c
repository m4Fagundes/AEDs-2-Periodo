#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
    char entrada[] = "AoQeaeAADeNtaehchec DguMksuuosoMkNeN";
    char variavel1[100] = "";
    char variavel2[100] = "";

    int alternar = 1;
    for (int i = 0; i < strlen(entrada); i++) {
        if (isalpha(entrada[i])) {
            if (alternar) {
                strncat(variavel1, &entrada[i], 1);
            } else {
                strncat(variavel2, &entrada[i], 1);
            }
            alternar = !alternar;
        }
    }

    printf("%s%s\n", variavel1, variavel2);

    return 0;
}
