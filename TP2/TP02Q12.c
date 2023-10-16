#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include <math.h>

typedef struct Jogador
{
    int id;
    char nome[31];
    int altura;
    int peso;
    char universidade[31];
    int anoNascimento;
    char cidadeNascimento[31];
    char estadoNascimento[31];
} Jogador;

void imprimir(Jogador jogador)
{
    printf("[");
    printf("%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s", jogador.id, jogador.nome, jogador.altura, jogador.peso, jogador.anoNascimento, jogador.universidade, jogador.cidadeNascimento, jogador.estadoNascimento);
    printf("]\n");
}

Jogador buscarJogadorPorId(int id, Jogador *jogadores, int qnt_jg)
{
    for (int i = 0; i < qnt_jg; i++)
    {
        if (id == jogadores[i].id)
        {
            return jogadores[i];
        }
    }
    Jogador jogadorNotFound;
    jogadorNotFound.id = -1;
    return jogadorNotFound;
}

Jogador ler(char *linha, int tam)
{
    Jogador jogador;
    int index[7];
    int virg = 0;
    for (int i = 0; i < tam; i++)
    {
        if (linha[i] == ',')
        {
            index[virg] = i;
            virg++;
        }
    }
    int i = 0;
    int j = 0;
    char id[5];
    while (i < index[0])
    {
        id[j] = linha[i];
        j++;
        i++;
    }
    id[j] = '\0';
    int id_integer = atoi(id);
    jogador.id = id_integer;
    i = index[0] + 1;
    j = 0;
    char nome[21];
    while (i < index[1])
    {
        nome[j] = linha[i];
        j++;
        i++;
    }
    nome[j] = '\0';
    strcpy(jogador.nome, nome);
    i = index[1] + 1;
    j = 0;
    char altura[4];
    while (i < index[2])
    {
        altura[j] = linha[i];
        j++;
        i++;
    }
    altura[j] = '\0';
    int altura_integer = atoi(altura);
    jogador.altura = altura_integer;
    i = index[2] + 1;
    j = 0;
    char peso[4];
    while (i < index[3])
    {
        peso[j] = linha[i];
        j++;
        i++;
    }
    peso[j] = '\0';
    int peso_integer = atoi(peso);
    jogador.peso = peso_integer;
    i = index[3] + 1;
    j = 0;
    char universidade[31];
    if ((index[4] - 1) - index[3] + 1 != 1)
    {
        while (i < index[4])
        {
            universidade[j] = linha[i];
            j++;
            i++;
        }
        universidade[j] = '\0';
    }
    else
    {
        strcpy(universidade, "nao informado");
    }
    strcpy(jogador.universidade, universidade);
    i = index[4] + 1;
    j = 0;
    char anoNascimento[5];
    while (i < index[5])
    {
        anoNascimento[j] = linha[i];
        j++;
        i++;
    }
    anoNascimento[j] = '\0';
    int anoNascimento_integer = atoi(anoNascimento);
    jogador.anoNascimento = anoNascimento_integer;
    i = index[5] + 1;
    j = 0;
    char cidadeNascimento[31];

    if (index[6] - index[5] + 1 != 2)
    {
        while (i < index[6])
        {
            cidadeNascimento[j] = linha[i];
            j++;
            i++;
        }
        cidadeNascimento[j] = '\0';
    }
    else
    {
        strcpy(cidadeNascimento, "nao informado");
    }
    strcpy(jogador.cidadeNascimento, cidadeNascimento);
    i = index[6] + 1;
    j = 0;
    char estadoNascimento[31];
    if ((tam - 3) - index[6] + 1 != 0)
    {
        while (i < tam - 1)
        {
            estadoNascimento[j] = linha[i];
            j++;
            i++;
        }
        estadoNascimento[j] = '\0';
    }
    else
    {
        strcpy(estadoNascimento, "nao informado");
    }
    strcpy(jogador.estadoNascimento, estadoNascimento);

    return jogador;
}



void swap(Jogador *x, Jogador *y ){
    Jogador temp = *x;
    *x = *y;
    *y = temp;
}

// void selectionSort(Jogador *jogador, int tamanho){
//     int min, contador=0;

//     while(contador<tamanho-1){
//         int menor = jogador[contador].nome;

//         for(int i= contador+1; i<tamanho; i++){
//             if(jogador[i].nome < menor){
//                 menor = jogador[i].nome;
//                 min = i;
//             }
//         }
//         swap(&jogador[contador], &jogador[min]);
//     }
    
// }

void selectionSort(Jogador *jogador, int tam)
{
    for (int i = 0; i < tam - 1; i++)
    {
        for (int j = (i + 1); j < tam; j++)
        {
            int comparacao = strcmp(jogador[i].nome, jogador[j].nome);
            if (comparacao > 0)
            {
                swap(&jogador[i], &jogador[j]);
            }
        }
    }
}
// void shellSort(Jogador *jogador, int tam)
// {
//     int i, j;
//     Jogador value;
//     int gap = 1;
//     while (gap < tam)
//     {
//         gap = 3 * gap + 1;
//     }
//     while (gap > 1)
//     {
//         gap /= 3;
//         for (i = gap; i < tam; i++)
//         {
//             value = jogador[i];
//             j = i - gap;
//             while (j >= 0 && value.peso < jogador[j].peso)
//             {
//                 jogador[j + gap] = jogador[j];
//                 j -= gap;
//             }
//             jogador[j + gap] = value;
//         }
//     }
// }

//shellSort atributo peso

void shellSort(Jogador array[], int n) {
    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            Jogador temp = array[i];
            int j;

            for (j = i; j >= gap && (
                array[j - gap].peso > temp.peso ||
                (array[j - gap].peso == temp.peso && strcmp(array[j - gap].nome, temp.nome) > 0)
            ); j -= gap) {
                array[j] = array[j - gap];
            }

            array[j] = temp;
        }
    }
}

void quickSort(Jogador *jogador, int esq, int dir){
    int i = esq, j = dir;
    Jogador pivo = jogador[(dir+esq)/2];
    while(i <= j){
        while(strcmp(jogador[i].estadoNascimento, pivo.estadoNascimento) < 0 || (strcmp(jogador[i].estadoNascimento, pivo.estadoNascimento) == 0 && strcmp(jogador[i].nome, pivo.nome) < 0)){
            i++;
        }
        while(strcmp(jogador[j].estadoNascimento, pivo.estadoNascimento) > 0 || (strcmp(jogador[j].estadoNascimento, pivo.estadoNascimento) == 0 && strcmp(jogador[j].nome, pivo.nome) > 0)){
            j--;
        }
        if(i <= j){
            swap(&jogador[i], &jogador[j]);
            i++;
            j--;
        }
    }
    if(esq < j){
        quickSort(jogador, esq, j);
    }
    if(i < dir){
        quickSort(jogador, i, dir);
    }
}

void bubbleSort(Jogador *jogadores, int numJogadores) {
    int i, j;
    for (i = 0; i < numJogadores - 1; i++) {
        for (j = 0; j < numJogadores - i - 1; j++) {
            if (jogadores[j].anoNascimento > jogadores[j + 1].anoNascimento ||
                (jogadores[j].anoNascimento == jogadores[j + 1].anoNascimento &&
                 strcmp(jogadores[j].nome, jogadores[j + 1].nome) > 0)) {
                swap(&jogadores[j], &jogadores[j + 1]);
            }
        }
    }
}

int main()
{

    //FILE *arq = fopen("players.csv", "r");
    FILE * arq = fopen("/tmp/players.csv", "r");

    if(arq == NULL){
        printf("falha no arquivo\n");
        return 1;
    }

    char linha[1001];
    int quant = 3922;
    Jogador jogador[quant];
    int jg_index = 0;

    fgets(linha, sizeof(linha), arq);
    while (fgets(linha, sizeof(linha), arq) != NULL)
    {
        int tam = strlen(linha);
        jogador[jg_index] = ler(linha, tam);
        jg_index++;
    }
    fclose(arq);
    char entrada[35];
    strcpy(entrada, "entrada");

    Jogador atletasManipular[quant];
    int i2 = 0;

    while (strcmp(entrada, "FIM") != 0)
    {
        scanf(" %[^\n]", entrada);
        if (strcmp(entrada, "FIM") != 0)
        {
            int idJogador = atoi(entrada);
            atletasManipular[i2] = buscarJogadorPorId(idJogador, jogador, quant);
            i2++;
        }
    }

    // Ordenar por selecao

    //selectionSort(atletasManipular, i2);
    //shellSort(atletasManipular, i2);
    //quickSort(atletasManipular, 0, i2-1);
    bubbleSort(atletasManipular, i2);

    //imprimir

    for(int i=0; i<i2; i++){
        imprimir(atletasManipular[i]);
    }

    
    return 0;
}