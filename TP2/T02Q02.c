#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Jogador {
    int id;
    char name[200];
    int altura;
    int peso;
    char universidade[200];
    int anoNascimento;
    char cidadeNascimento[200];
    char estadoNascimento[200];
} Jogador;

void atualizaLinha(char *linha) {
    char linhaAtualizada[300] = "";
    char origem[] = "nao informado";
    
    int i, j = 0;

    for (i = 0; linha[i]; i++) {
        if (linha[i] == ',' && linha[i + 1] == ',') {
            linhaAtualizada[j++] = ',';
            strcat(linhaAtualizada + j, origem);
            j += strlen(origem);
        } else {
            linhaAtualizada[j++] = linha[i];
        }
    }
    strcpy(linha, linhaAtualizada);
}

void atualizaArquivo() {
    FILE *jogadores = fopen("/tmp/players.csv", "r");
    FILE *atualizado = fopen("/tmp/playersAtualizado.csv", "wb");
    if (jogadores == NULL || atualizado == NULL) {
        perror("Erro ao abrir o arquivo");
        return;
    }
    char linha[300];  // Aumentado o tamanho para acomodar o caractere nulo

    while (fgets(linha, sizeof(linha), jogadores) != NULL) {
        atualizaLinha(linha);
        fprintf(atualizado, "%s", linha); 
    }

    fclose(jogadores);
    fclose(atualizado);
}

void salvarInfoJogadores(Jogador *jogadores, int tamanho) {
    FILE *jogadoresFile = fopen("/tmp/playersAtualizado.csv", "r");
    if (jogadoresFile == NULL) {
        perror("Erro ao abrir o arquivo");
        return;
    }

  char cabecalho[300];
    if (fgets(cabecalho, sizeof(cabecalho), jogadoresFile) == NULL) {
        perror("Erro ao ler o cabeçalho");
        fclose(jogadoresFile);
        return;
    }
    char linha[201];  // Aumentado o tamanho para acomodar o caractere nulo
    int i = 0;

    while (fgets(linha, sizeof(linha), jogadoresFile) != NULL && i < tamanho) {
        char *token;
        token = strsep(&linha, ",");
        int tokenIndex = 0;

        while (token != NULL) {
            switch (tokenIndex) {
                case 0:
                    jogadores[i].id = atoi(token);
                    break;
                case 1:
                    strcpy(jogadores[i].name, token);
                    break;
                case 2:
                    jogadores[i].altura = atoi(token);
                    break;
                case 3:
                    jogadores[i].peso = atoi(token);
                    break;
                case 4:
                    strcpy(jogadores[i].universidade, token);
                    break;
                case 5:
                    jogadores[i].anoNascimento = atoi(token);
                    break;
                case 6:
                    strcpy(jogadores[i].cidadeNascimento, token);
                    break;
                case 7:
                    strcpy(jogadores[i].estadoNascimento, token);
                    break;
            }
            token = strsep(&linha, ",");
            tokenIndex++;
        }

        i++;
    }

    fclose(jogadoresFile);
}

void printarJogadoresById(Jogador *jogadores, int tamanho, int id) {
    if (id < 0 || id > tamanho) {
        printf("ID inválido\n");
        return;
    }

    printf("Jogador %d\n", id);
    printf("## %s ##\n", jogadores[id].name);
    printf("## altura: %d ##\n", jogadores[id].altura);
    printf("## peso: %d ##\n", jogadores[id].peso);
    printf("## anoNascimento: %d ##\n", jogadores[id].anoNascimento);
    printf("## universidade: %s ##\n", jogadores[id].universidade);
    printf("## cidadeNascimento: %s ##\n", jogadores[id].cidadeNascimento);
    printf("## estadoNascimento: %s ##\n", jogadores[id].estadoNascimento);
}

void charToInt(char *str, int *num) {
    if (strcmp(str, "nao informado") == 0) {
        *num = -1;
    } else {
        *num = atoi(str);
    }
}

int main() {
    atualizaArquivo();

    int numLinhas = 3923; // Calcule o número de linhas com base no arquivo

    Jogador *jogador = (Jogador *)malloc(numLinhas * sizeof(Jogador));

    
    salvarInfoJogadores(jogador, numLinhas);

    char id[5];
    scanf("%s", id);
    while (id[0] != 'F') {
        int id = atoi(id);
        if (id != -1) {
            printarJogadoresById(jogador, numLinhas, id);
        }
    }
    

    free(jogador);

    return 0;
}
