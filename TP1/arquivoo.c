#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *arquivo;
    int n;

    arquivo = fopen("numeros.txt", "wb");

    if (arquivo == NULL) {
        perror("Erro ao abrir o arquivo");
        return 1;
    }

    
    scanf("%d", &n);

    // Lê e salva os números no arquivo
    for (int i = 0; i < n; i++) {
        double numeroDigitado;
        scanf("%lf", &numeroDigitado);

        fwrite(&numeroDigitado, sizeof(double), 1, arquivo);
    }

    fclose(arquivo);

    arquivo = fopen("numeros.txt", "rb");

    if (arquivo == NULL) {
        perror("Erro ao abrir o arquivo");
        return 1;
    }

    fseek(arquivo, -sizeof(double), SEEK_END); // Posiciona antes do último número

    double ultimoNumero;
    fread(&ultimoNumero, sizeof(double), 1, arquivo);
    printf("%g\n", ultimoNumero); // Use %g para remover zeros inúteis

    fseek(arquivo, -2 * sizeof(double), SEEK_CUR); // Posiciona antes do penúltimo número

    while (ftell(arquivo) >= sizeof(double)) { // Verifica se ainda há pelo menos 8 bytes para ler
        double numeroLido;
        fread(&numeroLido, sizeof(double), 1, arquivo);
        printf("%g\n", numeroLido); // Use %g para remover zeros inúteis

        fseek(arquivo, -2 * sizeof(double), SEEK_CUR);
    }

    // Fecha o arquivo novamente
    fclose(arquivo);

    return 0;
}
