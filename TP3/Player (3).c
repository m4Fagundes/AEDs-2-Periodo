/**
 * @path TP02Q02 - Classe em C/Player.c
 * @description C file that implements the Player class.
 * @author Matheus Fagundes
 */

// ---------------------------------------------------------------------------------------------------- //

// Includes
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

// ---------------------------------------------------------------------------------------------------- //

// Constants
#define MAX_PLAYERS 4000
#define FILE_PATH "/tmp/players.csv"
//#define FILE_PATH "players.csv"

#define MAX_NAME_SIZE 40
#define MAX_COLLEGE_SIZE 60
#define MAX_BIRTH_CITY_SIZE 40
#define MAX_BIRTH_STATE_SIZE 40

#define MAX_LINE_SIZE 300
#define MAX_ATTRIBUTE_SIZE 100
#define FILA_TAMANHO 6

// ---------------------------------------------------------------------------------------------------- //

// Structs
typedef struct Player
{
    int id;
    char *name;
    int height;
    int weight;
    int birthYear;
    char *birthCity;
    char *birthState;
    char *college;
} Player;

typedef struct FilaCircular {
    Player* arr;
    int primerio, ultimo;
    int n;
}FilaCircular;

// ---------------------------------------------------------------------------------------------------- //

// Global variables
Player players[MAX_PLAYERS];
int playersLength = 0;

// ---------------------------------------------------------------------------------------------------- //

// Functions
bool isEnd(char *line) { return line[0] == 'F' && line[1] == 'I' && line[2] == 'M'; }

void substring(char *string, char *stringStart, int length)
{

    strncpy(string, stringStart, length);
    string[length] = '\0';
}

void proccess_attribute(char *attribute, char **substringStart, char **substringEnd, bool isFirstAttribute)
{

    // Skip first comma
    if (!isFirstAttribute)
    {

        if (*substringEnd != NULL)
            *substringStart = *substringEnd + 1;
        else
            *substringStart = *substringEnd;
    }

    // Get next comma
    *substringEnd = strchr(*substringStart, ',');

    // Get substring
    if (*substringEnd)
        substring(attribute, *substringStart, *substringEnd - *substringStart);
    else
        strcpy(attribute, *substringStart);

    // Set default value if attribute is empty
    if (strcmp(attribute, "") == 0 || attribute[0] == '\n' || attribute[0] == '\r' || attribute[0] == '\0')
        strcpy(attribute, "nao informado");

    // Clean \n from the end of the string
    if (attribute[strlen(attribute) - 1] == '\n')
        attribute[strlen(attribute) - 1] = '\0';
}
// ---------------------------------------------------------------------------------------------------- //

// Methods signatures

// Class
Player player_newBlank();
Player player_new(int id, char *name, int height, int weight, int birthYear, char *birthCity, char *birthState, char *college);
Player *player_clone(Player *player);
void player_print(Player *player);
Player player_read(char *line);
Player *player_searchById(int id);

// Gets
int player_getId(Player *player);
char *player_getName(Player *player);
int player_getHeight(Player *player);
int player_getWeight(Player *player);
char *player_getCollege(Player *player);
int player_getBirthYear(Player *player);
char *player_getBirthCity(Player *player);
char *player_getBirthState(Player *player);

// Sets
void player_setId(Player *player, int id);
void player_setName(Player *player, char *name);
void player_setHeight(Player *player, int height);
void player_setWeight(Player *player, int weight);
void player_setCollege(Player *player, char *college);
void player_setBirthYear(Player *player, int birthYear);
void player_setBirthCity(Player *player, char *birthCity);
void player_setBirthState(Player *player, char *birthState);

// General
void startPlayers();

// ---------------------------------------------------------------------------------------------------- //
// list methods
FilaCircular* criarFilaCircular(){
    FilaCircular* novaFilaCircular = malloc(sizeof(FilaCircular));
    novaFilaCircular->arr = malloc((FILA_TAMANHO)*sizeof(Player));
    novaFilaCircular->primerio = 0;
    novaFilaCircular->ultimo = 0;
    novaFilaCircular->n = 0;
    return novaFilaCircular;
}

void imprimir(Player jogador)
{
    printf("[%d] ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n", jogador.id, jogador.name, jogador.height, jogador.weight, jogador.birthYear, jogador.college, jogador.birthCity, jogador.birthState);
}

void mostrarFila(FilaCircular* fila) {
    int tam = fila->n;
    for(int i = 0; i < tam; i++) {
        imprimir(fila->arr[i]);
    }
}

Player remover(FilaCircular* fila) {
    Player resp;
    if(fila->primerio == fila->ultimo) {
        printf("FILA VAZIA JA!\n");
        return resp;
    }
    resp = fila->arr[fila->primerio];
    fila->primerio = (fila->primerio + 1) % FILA_TAMANHO;
    fila->n--;
    return resp;
}

void inserir(FilaCircular* fila, Player x) {
    if( ((fila->ultimo + 1) % FILA_TAMANHO) == fila->primerio)
    {
        fila->primerio = (fila->primerio + 1) % FILA_TAMANHO;
        fila->arr[fila->ultimo] = x;
        fila->ultimo = (fila->ultimo + 1) % FILA_TAMANHO;
    }else{
        fila->arr[fila->ultimo] = x;
        fila->ultimo = (fila->ultimo + 1) % FILA_TAMANHO;
        fila->n++;
    }
}

int mediaAltura(FilaCircular* fila){

    int alturas = 0;
    int numJogadores = fila->n;

    int i = fila->primerio;

    while(i != fila->ultimo)
    {
        alturas += fila->arr[i].height;
        i = (i+1) % FILA_TAMANHO;
    }

    float tmp = ((float)alturas/(float)numJogadores);
    float parte_decimal = fmod(tmp, 1.0);

    if(parte_decimal > 0.5)
    {
        return (alturas/numJogadores)+1;
    }
    return alturas/numJogadores;
}
void alterarIdParaPosicao(FilaCircular*fila){
    int tam = fila->n;
    for(int i = 0; i <= tam-1; i++){
        fila->arr[i].id = i;
    }
}

// ---------------------------------------------------------------------------------------------------- //
// Methods implementations

// Class
Player player_newBlank()
{

    Player player;

    player.id = -1;
    player.height = -1;
    player.weight = -1;
    player.birthYear = -1;

    player.name = (char *)calloc(MAX_NAME_SIZE, sizeof(char));
    strcpy(player.name, "");

    player.birthCity = (char *)calloc(MAX_BIRTH_CITY_SIZE, sizeof(char));
    strcpy(player.birthCity, "");

    player.birthState = (char *)calloc(MAX_BIRTH_STATE_SIZE, sizeof(char));
    strcpy(player.birthState, "");

    player.college = (char *)calloc(MAX_COLLEGE_SIZE, sizeof(char));
    strcpy(player.college, "");

    return player;
}

Player player_new(int id, char *name, int height, int weight, int birthYear, char *birthCity, char *birthState, char *college)
{

    Player player;

    player.id = id;
    player.height = height;
    player.weight = weight;
    player.birthYear = birthYear;

    player.name = (char *)calloc(MAX_NAME_SIZE, sizeof(char));
    strcpy(player.name, name);

    player.birthCity = (char *)calloc(MAX_BIRTH_CITY_SIZE, sizeof(char));
    strcpy(player.birthCity, birthCity);

    player.birthState = (char *)calloc(MAX_BIRTH_STATE_SIZE, sizeof(char));
    strcpy(player.birthState, birthState);

    player.college = (char *)calloc(MAX_COLLEGE_SIZE, sizeof(char));
    strcpy(player.college, college);

    return player;
}

Player *player_clone(Player *player)
{

    Player *clone = (Player *)malloc(sizeof(Player));

    clone->id = player->id;
    clone->height = player->height;
    clone->weight = player->weight;

    clone->name = (char *)calloc(MAX_NAME_SIZE, sizeof(char));
    strcpy(clone->name, player->name);

    clone->birthCity = (char *)calloc(MAX_BIRTH_CITY_SIZE, sizeof(char));
    strcpy(clone->birthCity, player->birthCity);

    clone->birthState = (char *)calloc(MAX_BIRTH_STATE_SIZE, sizeof(char));
    strcpy(clone->birthState, player->birthState);

    clone->college = (char *)calloc(MAX_COLLEGE_SIZE, sizeof(char));
    strcpy(clone->college, player->college);

    return clone;
}
void player_print(Player *player)
{

    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n",
           player->id,   
           player->name,
           player->height,
           player->weight,
           player->birthYear,
           player->college,
           player->birthCity,
           player->birthState);
}

Player player_read(char *line)
{

    Player player = player_newBlank();

    char *substringStart = line;
    char *substringEnd = NULL;
    char attribute[MAX_ATTRIBUTE_SIZE];

    // Get id
    proccess_attribute(attribute, &substringStart, &substringEnd, true);
    player_setId(&player, atoi(attribute));

    // Get name
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setName(&player, attribute);

    // Get height
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setHeight(&player, atoi(attribute));

    // Get weight
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setWeight(&player, atoi(attribute));

    // Get college
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setCollege(&player, attribute);

    // Get birth year
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setBirthYear(&player, atoi(attribute));

    // Get birth city
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setBirthCity(&player, attribute);

    // Get birth state
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setBirthState(&player, attribute);

    return player;
}

Player *player_searchById(int id)
{

    for (int i = 0; i < playersLength; i++)
    {

        if (player_getId(&players[i]) == id)
            return &players[i];
    }
    return NULL;
}

// Gets
int player_getId(Player *player) { return player->id; }
char *player_getName(Player *player) { return player->name; }
int player_getHeight(Player *player) { return player->height; }
int player_getWeight(Player *player) { return player->weight; }
char *player_getCollege(Player *player) { return player->college; }
int player_getBirthYear(Player *player) { return player->birthYear; }
char *player_getBirthCity(Player *player) { return player->birthCity; }
char *player_getBirthState(Player *player) { return player->birthState; }

// Sets
void player_setId(Player *player, int id) { player->id = id; }
void player_setName(Player *player, char *name) { strcpy(player->name, name); }
void player_setHeight(Player *player, int height) { player->height = height; }
void player_setWeight(Player *player, int weight) { player->weight = weight; }
void player_setBirthYear(Player *player, int birthYear) { player->birthYear = birthYear; }
void player_setBirthCity(Player *player, char *birthCity) { strcpy(player->birthCity, birthCity); }
void player_setBirthState(Player *player, char *birthState) { strcpy(player->birthState, birthState); }
void player_setCollege(Player *player, char *college) { strcpy(player->college, college); }


// General
void startPlayers()
{

    // Open file
    FILE *fp;
    char *line = NULL;
    size_t len = 0;
    size_t read;

    fp = fopen(FILE_PATH, "r");

    if (fp == NULL)
    {

        perror("x Error opening file");
        exit(EXIT_FAILURE);
    }

    // Skip first line
    getline(&line, &len, fp);

    // Read all lines
    while ((read = getline(&line, &len, fp)) != -1)
    {

        // Read player from line
        Player player = player_read(line);

        players[playersLength++] = player;

        if (playersLength >= MAX_PLAYERS)
        {

            perror("x Max players reached");
            exit(EXIT_FAILURE);
        }
    }

    // Close file and free memory
    fclose(fp);

    if (line)
        free(line);
}

// ---------------------------------------------------------------------------------------------------- //

// Main
int main()
{

    // ----------------------------------------------------------------- //
    // #1 - Start - Read all players in CSV file
    startPlayers();

    // ----------------------------------------------------------------- //
    // #2 - Initialize the List Class

    FilaCircular *filaCircular = criarFilaCircular();
    // ----------------------------------------------------------------- //

    // #3 - Read input and print players from pub.in id entries
    char in[5];
    scanf(" %[^\n]s", in);

    while (true)
    {

        if (isEnd(in))
            break;
        else
        {

            int id = atoi(in);

            // ------------------------- //

            Player *foundPlayer = player_searchById(id);
            inserir(filaCircular, *foundPlayer);
            printf("%d\n", mediaAltura(filaCircular));

            // ------------------------- //

            scanf(" %[^\n]s", in);
        }
    }

    int quant;
    scanf("%d", &quant);

    for (int i = 0; i < quant; i++)
    {
        char in[5];
        scanf("%s", in);

        if (strcmp(in, "R") == 0)
        {
            printf("(R) %s\n", remover(filaCircular).name);
        }

        if (strcmp(in, "I") == 0)
        {
            int id;
            scanf("%d", &id);
            Player *foundPlayer = player_searchById(id);
            inserir(filaCircular, *foundPlayer);
            printf("%d\n", mediaAltura(filaCircular));
        }
    }

    

    // ----------------------------------------------------------------- //
    // #4 - Print list
    mostrarFila(filaCircular);


    return 0;
}