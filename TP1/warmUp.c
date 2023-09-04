/*
Autor - Matheus Fagundes
Ultima Atualizacao - 25/10/2020
Objetivo - Concatenar strings
*/

#include <stdio.h>
#include <string.h>

int contador(char *frase);

int main(void)
{
    char frase1[100], frase2[100], fraseJunta[200];

    scanf("%s %s", frase1, frase2);
    printf("%c", frase2[0]);
    for (int i = 0; i < 200; i++)
    {
        fraseJunta[i] = frase1[i];
        fraseJunta[i + 1] = frase2[i];
    }

    printf("%s\n", fraseJunta);

    return 0;
}

int contador(char *frase)
{
    int contador = 0;
    for (int i = 0; i < 100; i++)
    {
        if (frase[i] == '\0')
            return contador;
        else
            contador++;
    }
    return contador;
}
