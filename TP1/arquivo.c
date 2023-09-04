#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;
    printf("Digite o numero de valores reais a serem lidos: ");
    scanf("%d", &n);

    FILE *file = fopen("valores.txt", "w");

    // Lê e salva os valores sequencialmente no arquivo
    double valor;
    for (int i = 0; i < n; i++) {
        printf("Digite o valor real #%d: ", i + 1);
        scanf("%lf", &valor);
        fprintf(file, "%lf\n", valor);
    }

    // Fecha o arquivo
    fclose(file);

    // Reabre o arquivo para leitura reversa
    file = fopen("valores.txt", "r");

    // Move o ponteiro para o final do arquivo
    fseek(file, 0, SEEK_END);

    // Lê e mostra os valores de trás para frente
    printf("Valores lidos de tras para frente:\n");
    while (ftell(file) > 0) {
        fseek(file, -sizeof(double), SEEK_CUR);
        fread(&valor, sizeof(double), 1, file);
        printf("%lf\n", valor);
    }

    // Fecha o arquivo novamente
    fclose(file);

    return 0;
}
