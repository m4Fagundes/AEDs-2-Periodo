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

typedef struct CelulaDupla
{
    Player elemento;
    struct CelulaDupla *prox;
    struct CelulaDupla *ant;
} CelulaDupla;

// ---------------------------------------------------------------------------------------------------- //

// Global variables
Player players[MAX_PLAYERS];
int playersLength = 0;
CelulaDupla *primeiro;
CelulaDupla *ultimo;

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
CelulaDupla *novaCelulaDupla(Player player)
{
    CelulaDupla *nova = (CelulaDupla *)malloc(sizeof(CelulaDupla));
    nova->elemento = player;
    nova->ant = nova->prox = NULL;
    return nova;
}

int tamanho()
{
    int tamanho = 0;
    CelulaDupla *i;
    for (i = primeiro; i != ultimo; i = i->prox, tamanho++);
    return tamanho;
}

void start()
{
    primeiro = novaCelulaDupla(player_newBlank());
    ultimo = primeiro;
}

void inserirInicio(Player player)
{
    CelulaDupla *tmp = novaCelulaDupla(player);

    tmp->ant = primeiro;
    tmp->prox = primeiro->prox;
    primeiro->prox = tmp;
    if (primeiro == ultimo)
    {
        ultimo = tmp;
    }
    else
    {
        tmp->prox->ant = tmp;
    }
    tmp = NULL;
}

void inserirFim(Player player)
{
    CelulaDupla *nova = novaCelulaDupla(player);
    ultimo->prox = nova;
    nova->ant = ultimo;
    ultimo = nova;
}
void inserir(Player player, int pos)
{
    int tam = tamanho();
    if (pos < 0 || pos > tam)
    {
        printf("Erro ao inserir posicao (%d/%d) invalida!\n", pos, tam);
        exit(1);
    }
    else if (pos == 0)
    {
        inserirInicio(player);
    }
    else if (pos == tam)
    {
        inserirFim(player);
    }
    else
    {
        // Caminhar ate a posicao anterior a insercao
        CelulaDupla *i = primeiro;
        int j;
        for (j = 0; j < pos; j++, i = i->prox);

        CelulaDupla *tmp = novaCelulaDupla(player);
        tmp->ant = i;
        tmp->prox = i->prox;
        tmp->ant->prox = tmp->prox->ant = tmp;
        tmp = i = NULL;
    }
}
Player removerInicio()
{
    if (primeiro == ultimo)
    {
        printf("Erro ao remover (vazia)!\n");
        exit(1);
    }

    CelulaDupla *tmp = primeiro;
    primeiro = primeiro->prox;
    Player resp = primeiro->elemento;
    tmp->prox = primeiro->ant = NULL;
    free(tmp);
    tmp = NULL;
    return resp;
}
Player removerFim()
{
    if (primeiro == ultimo)
    {
        printf("Erro ao remover (vazia)!\n");
        exit(1);
    }
    Player resp = ultimo->elemento;
    ultimo = ultimo->ant;
    ultimo->prox->ant = NULL;
    free(ultimo->prox);
    ultimo->prox = NULL;
    return resp;
}
Player remover(int pos){
    Player resp;
    int tam = tamanho();

    if(primeiro == ultimo){
        printf("Erro ao remover (vazia)!\n");
        exit(1);
    } else if(pos == 0){
        resp = removerInicio();
    } else if(pos == tam-1){
        resp = removerFim();
    } else{
        //caminahar ate a posicao anterior a remocao
        CelulaDupla* i = primeiro->prox;
        int j;
        for(j = 0; j < pos; j++, i = i->prox);

        i->ant->prox = i->prox;
        i->prox->ant = i->ant;
        resp = i->elemento;
        i->prox = i->ant = NULL;
        free(i);
        i = NULL;
    }
    return resp;
}

void mostrar()
{
    int j = 0;
    for (CelulaDupla *i = primeiro->prox; i != NULL; i = i->prox, j++)
    {
        printf("[%d] ", j);
        player_print(&(i->elemento));
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

    printf("## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n",
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

    start();

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
            inserirFim(*foundPlayer);

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

        if (strcmp(in, "II") == 0)
        {
            int id;
            scanf("%d", &id);
            Player *foundPlayer = player_searchById(id);
            inserirInicio(*foundPlayer);
        }

        if (strcmp(in, "I") == 0)
        {
            int id;
            scanf("%d", &id);
            Player *foundPlayer = player_searchById(id);
            inserirFim(*foundPlayer);
        }

        if (strcmp(in, "RI") == 0)
        {
            printf("(R) %s\n", removerInicio().name);
        }

        if (strcmp(in, "R") == 0)
        {
            printf("(R) %s\n", removerFim().name);
        }

        if (strcmp(in, "I*") == 0)
        {
            int pos;
            scanf("%d", &pos);
            int id;
            scanf("%d", &id);
            Player *foundPlayer = player_searchById(id);
            inserir(*foundPlayer, pos);
        }

        if (strcmp(in, "R*") == 0)
        {
            int pos;
            scanf("%d", &pos);
            printf("(R) %s\n", remover(pos).name);
        }
    }

    // ----------------------------------------------------------------- //
    // #4 - Print list
    mostrar();

    return 0;
}