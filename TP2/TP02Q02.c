#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int id;
    char player[100]; // Ajuste o tamanho conforme necessário
    int height;
    int weight;
    char college[100]; // Ajuste o tamanho conforme necessário
    int born;
    char birth_city[100]; // Ajuste o tamanho conforme necessário
    char birth_state[100]; // Ajuste o tamanho conforme necessário
} Jogador;

int contaCaracters(const char *linha)
{
    int count = 0;
    while (linha[count] != '\0')
    {
        count++;
    }
    return count;
}

void atualizaLinha(char *linha)
{
    char linhaAtualizada[300] = "";
    char origem[] = "nao informado";
    char origem2[] = "nao informado,nao informado";
    int contador = contaCaracters(linha);
    int i, j = 0;
    int contadorVirgula = 0;
    for (i = 0; linha[i]; i++)
    {
        if (linha[i] == ',')
        {
            contadorVirgula++;
        }
        if (linha[i] == ',' && linha[i + 1] == ',' && contadorVirgula == 6)
        {
            linhaAtualizada[j++] = ',';
            strcat(linhaAtualizada + j, origem2);
            j += strlen(origem2);
        }
        else if (linha[i] == ',' && linha[i + 1] == ',')
        {
            linhaAtualizada[j++] = ',';
            strcat(linhaAtualizada + j, origem);
            j += strlen(origem);
        }
        else
        {
            linhaAtualizada[j++] = linha[i];
        }
    }
    strcpy(linha, linhaAtualizada);
}

void abreFechaLeEAtualizaArquivo(){
    FILE *arq = fopen("players.csv", "r+");
    if (arq == NULL) {
        printf("Erro ao abrir o arquivo");
        exit(1);
    }

    FILE *temp = fopen("temp.csv", "w");
    if (temp == NULL) {
        printf("Erro ao criar o arquivo temporário");
        fclose(arq);
        exit(1);
    }

    char linha[300];

    while (fgets(linha, sizeof(linha), arq) != NULL) {
        atualizaLinha(linha);
        fprintf(temp, "%s", linha);
    }

    fclose(arq);
    fclose(temp);

    // Substituir o arquivo original pelo arquivo temporário
    remove("players.csv");
    rename("temp.csv", "players.csv");
}
char* verificar (char palavra[]) {
    if (!palavra || strcmp(palavra, "nao informado,") == 0) {
        return "nao informado";
    }
    return palavra;
}
void lerDados(Jogador atleta[]) {
    FILE *arqJogador = fopen("players.csv", "r");

    if (arqJogador == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        exit(1);
    }

    for (int i = 0; i < 3922; i++) {
        char linha[500];
        fgets(linha, sizeof(linha), arqJogador);

        char *token = strtok(linha, ",");
        atleta[i].id = atoi(token);
        token = strtok(NULL, ",");
        strcpy(atleta[i].player, token);
        token = strtok(NULL, ",");
        atleta[i].height = atoi(token);
        token = strtok(NULL, ",");
        atleta[i].weight = atoi(token);
        token = strtok(NULL, ",");
        strcpy(atleta[i].college, verificar(token));
        token = strtok(NULL, ",");
        atleta[i].born = atoi(token);
        token = strtok(NULL, ",");
        strcpy(atleta[i].birth_city, verificar(token));
        token = strtok(NULL, "\n");
        strcpy(atleta[i].birth_state, verificar(token));
    }

    fclose(arqJogador);
}

void imprimirJogador(const Jogador *jogador) {
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", 
           jogador->id, jogador->player, jogador->height, jogador->weight,
           jogador->born, jogador->college, jogador->birth_city, jogador->birth_state);
}

int pesquisarJogadorPorID(const Jogador *jogadores, int numJogadores, int idPesquisado) {
    for (int i = 0; i < numJogadores; i++) {
        if (jogadores[i].id == idPesquisado) {
            imprimirJogador(&jogadores[i]);
            return 1; // Jogador encontrado
        }
    }
    return 0; // Jogador não encontrado
}

void printarAteEscreverFIM(Jogador atleta[]){
    int numJogadores = 3923;
    int contador=0;
    char entrada[50];
    while (1) { 
        scanf("%s", entrada);

        if (strcmp(entrada, "FIM") == 0) {
            break;
        }
        int idPesquisado = atoi(entrada);

        int encontrado = pesquisarJogadorPorID(atleta, numJogadores, idPesquisado);

        if (!encontrado) {
            printf("Jogador com ID %d não encontrado.\n", idPesquisado);
        }
        contador++;
    }
}

int main(void) {
    
    abreFechaLeEAtualizaArquivo();

    Jogador atleta[3922];

    lerDados(atleta);
    printarAteEscreverFIM(atleta);
    

    return 0;
}