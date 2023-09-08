/*
Autor - Matheus Fagundes
Ultima Atualizacao - 25/10/2020
Objetivo - Intercalar cada caracter de 2 strings
*/

#include <stdio.h>
#include <string.h>

#include <stdio.h>
#include <string.h>

#include <stdio.h>
#include <string.h>

int contador(char *frase);

int main(void)
{
    char frase1[100], frase2[100], fraseJunta[200];
    int controlador = 0;
    while (controlador != 3)
    {

        scanf("%s %s", frase1, frase2);

        int quant1 = contador(frase1);
        int quant2 = contador(frase2);

        frase1[quant1] = '\0';
        frase2[quant2] = '\0';

        int maiorQuant;
        if (quant1 > quant2)
        {
            maiorQuant = quant1;
        }
        else
        {
            maiorQuant = quant2;
        }
        int contador = 0;

        for (int i = 0; i < maiorQuant; i++)
        {
            if (i < quant1)
            {
                fraseJunta[contador] = frase1[i];
                contador++;
            }
            if (i < quant2)
            {
                fraseJunta[contador] = frase2[i];
                contador++;
            }
        }

        fraseJunta[contador] = '\0';
        printf("%s\n", fraseJunta);
        controlador++;
    }

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

