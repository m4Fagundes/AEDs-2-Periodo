
//---------------------------------------------------------------------------------------------------- //
// Imports
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// ---------------------------------------------------------------------------------------------------- //

public class Player {

    // Global variables
    public static final String FILE_PATH = "/tmp/players.csv";
    //public static final String FILE_PATH = "players.csv";
    public static ArrayList<Player> allPlayers = new ArrayList<Player>();

    // -------------------------- //

    // Attributes
    private int id;
    private String name;
    private int height;
    private int weight;
    private String college;
    private int yearOfBirth;
    private String birthCity;
    private String birthState;

    // Empty constructor
    public Player() {

        this.id = 0;
        this.name = "";
        this.height = 0;
        this.weight = 0;
        this.college = "";
        this.yearOfBirth = 0;
        this.birthCity = "";
        this.birthState = "";
    }

    // Constructor
    public Player(int id, String name, int height, int weight, String college, int yearOfBirth, String birthCity,
            String birthState) {

        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.college = college;
        this.yearOfBirth = yearOfBirth;
        this.birthCity = birthCity;
        this.birthState = birthState;
    }

    // Gets
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getCollege() {
        return this.college;
    }

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }

    public String getBirthCity() {
        return this.birthCity;
    }

    public String getBirthState() {
        return this.birthState;
    }

    // Sets
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    // Clone
    public Player clone() {
        return new Player(this.id, this.name, this.height, this.weight, this.college, this.yearOfBirth, this.birthCity,
                this.birthState);
    }

    // Print
    public void print() {

        System.out.printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n",
                this.id, this.name, this.height, this.weight, this.yearOfBirth, this.college, this.birthCity,
                this.birthState);
    }

    // Read
    public void read(String line) {

        // Split line by ","
        String[] splitted = line.split(",", -1);

        // Fill empty attributes
        for (int i = 0; i < splitted.length; i++) {

            if (splitted[i].equals(""))
                splitted[i] = "nao informado";
        }

        // Set attributes
        this.id = Integer.parseInt(splitted[0]);
        this.name = splitted[1];
        this.height = Integer.parseInt(splitted[2]);
        this.weight = Integer.parseInt(splitted[3]);
        this.college = splitted[4];
        this.yearOfBirth = Integer.parseInt(splitted[5]);
        this.birthCity = splitted[6];
        this.birthState = splitted[7];
    }

    // ----------------------------------------------------------------------------------------------------
    // //
    // Classe lista flexivel
    public static class ListaFlex {

        class Celula {
            public Player elemento; // Elemento inserido na celula.
            public Celula prox; // Aponta a celula prox.

            // Construtor da classe.
            public Celula() {
                this(null);
            }

            // Construtor da classe.
            public Celula(Player player) {
                this.elemento = player;
                this.prox = null;
            }
        }

        class Lista {
            private Celula primeiro;
            private Celula ultimo;

            // Construtor da classe que cria uma lista sem elementos (somente no cabeca).
            public Lista() {
                primeiro = new Celula();
                ultimo = primeiro;
            }

            // Remover inicio
            public void inserirInicio(Player player) {
                Celula tmp = new Celula(player);
                tmp.prox = primeiro.prox;
                primeiro.prox = tmp;
                if (primeiro == ultimo) {
                    ultimo = tmp;
                }
                tmp = null;
            }

            public void inserirFim(Player player) {
                ultimo.prox = new Celula(player);
                ultimo = ultimo.prox;
            }

            // Remover inicio
            public Player removerInicio() throws Exception {
                if (primeiro == ultimo) {
                    throw new Exception("Erro ao remover (vazia)!");
                }

                Celula tmp = primeiro;
                primeiro = primeiro.prox;
                Player resp = primeiro.elemento;
                tmp.prox = null;
                tmp = null;
                return resp;
            }

            // Remover fim
            public Player removerFim() throws Exception {
                if (primeiro == ultimo) {
                    throw new Exception("Erro ao remover (vazia)!");
                }

                // Caminhar ate a penultima celula:
                Celula i;
                for (i = primeiro; i.prox != ultimo; i = i.prox)
                    ;

                Player resp = ultimo.elemento;
                ultimo = i;
                i = ultimo.prox = null;

                return resp;
            }

            // Insere um elemento em uma posicao especifica considerando que o
            public void inserir(Player player, int pos) throws Exception {

                int tamanho = tamanho();

                if (pos < 0 || pos > tamanho) {
                    throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
                } else if (pos == 0) {
                    inserirInicio(player);
                } else if (pos == tamanho) {
                    inserirFim(player);
                } else {
                    // Caminhar ate a posicao anterior a insercao
                    Celula i = primeiro;
                    for (int j = 0; j < pos; j++, i = i.prox)
                        ;

                    Celula tmp = new Celula(player);
                    tmp.prox = i.prox;
                    i.prox = tmp;
                    tmp = i = null;
                }
            }

            // Remove um elemento de uma posicao especifica da lista
            public Player remover(int pos) throws Exception {
                Player resp;
                int tamanho = tamanho();

                if (primeiro == ultimo) {
                    throw new Exception("Erro ao remover (vazia)!");

                } else if (pos < 0 || pos >= tamanho) {
                    throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
                } else if (pos == 0) {
                    resp = removerInicio();
                } else if (pos == tamanho - 1) {
                    resp = removerFim();
                } else {
                    // Caminhar ate a posicao anterior a insercao
                    Celula i = primeiro;
                    for (int j = 0; j < pos; j++, i = i.prox)
                        ;

                    Celula tmp = i.prox;
                    resp = tmp.elemento;
                    i.prox = tmp.prox;
                    tmp.prox = null;
                    i = tmp = null;
                }

                return resp;
            }

            // Mostra os elementos da lista separados por espacos.
            public void mostrar() {
                int contador = 0;
                for (Celula i = primeiro.prox; i != null; i = i.prox, contador++) {
                    Player jogador = i.elemento;
                    System.out.printf("[%d] ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n",
                            contador, jogador.getName(), jogador.getHeight(), jogador.getWeight(),
                            jogador.getYearOfBirth(), jogador.getCollege(), jogador.getBirthCity(),
                            jogador.getBirthState());

                }
            }

            // Procura um elemento e retorna se ele existe.
            public boolean pesquisar(Player player) {
                boolean resp = false;
                for (Celula i = primeiro.prox; i != null; i = i.prox) {
                    if (i.elemento == player) {
                        resp = true;
                        i = ultimo;
                    }
                }
                return resp;
            }

            // Calcula e retorna o tamanho, em numero de elementos, da lista.
            public int tamanho() {
                int tamanho = 0;
                for (Celula i = primeiro; i != ultimo; i = i.prox, tamanho++)
                    ;
                return tamanho;
            }
        }
    }

    // ----------------------------------------------------------------------------------------------------
    // //
    // Read all players function
    public static void startPlayers() {

        // Initialize variables
        try {

            FileInputStream fstream = new FileInputStream(FILE_PATH);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            // ---------------------- //

            // Explode CSV file
            String line = br.readLine();

            while ((line = br.readLine()) != null) {

                // Initialize player
                Player player = new Player();

                // Read line
                player.read(line);

                // Add player to array
                allPlayers.add(player);
            }

            // Close CSV file
            fstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ----------------------------------------------------------------------------------------------------
    // //

    // Search by id function
    public static Player searchById(int id, ArrayList<Player> players) {

        // Search for player
        for (int i = 0; i < players.size(); i++) {

            if (players.get(i).getId() == id)
                return players.get(i);
        }
        return null;
    }

    // ----------------------------------------------------------------------------------------------------
    // //

    public static void main(String[] args) throws Exception {

        // ----------------------------------------------------------------- //

        // #1 - Start - Read all players in CSV file
        startPlayers();

        // ----------------------------------------------------------------- //
        // #2 - Start - Start flexible list
        ListaFlex listaFlex = new ListaFlex();
        ListaFlex.Lista lista = listaFlex.new Lista();

        // ----------------------------------------------------------------- //

        // #3 - Read input and print players from pub.in id entries

        // Initialize scanner
        Scanner inScanner = new Scanner(System.in);

        // Initialize player
        Player player = new Player();

        // Read first line
        String line = inScanner.nextLine();

        // While line is not "FIM
        while (!line.equals("FIM")) {

            // Get id
            int id = Integer.parseInt(line);

            // Search for player
            player = searchById(id, allPlayers);

            // Print player
            lista.inserirFim(player);

            // Read line
            line = inScanner.nextLine();
        }

        int index = inScanner.nextInt();
        inScanner.nextLine();

        // ----------------------------------------------------------------- //
        // #4 - Read input and execute commands
        for (int i = 0; i < index; i++) {
            String entrada = inScanner.next();
            //System.out.println(entrada);
            
            if (entrada.equals("II")) 
            {
                int Id = inScanner.nextInt();
                inScanner.nextLine();
                lista.inserirInicio(searchById(Id, allPlayers));
            } 

            else if (entrada.equals("IF")) 
            {
                int Id = inScanner.nextInt();
                inScanner.nextLine();
                lista.inserirFim(searchById(Id, allPlayers));
            } 

            else if (entrada.equals("R*")) 
            {
                int Id = inScanner.nextInt();
                inScanner.nextLine();
                System.out.println("(R) " + lista.remover(Id).getName());
            } 

            else if(entrada.equals("I*"))
            {
                int pos = inScanner.nextInt();
                int Id = inScanner.nextInt();
                inScanner.nextLine();
                lista.inserir(searchById(Id, allPlayers), pos);
            } 

            else if(entrada.equals("RI"))
            {
                System.out.println("(R) " + lista.removerInicio().getName());
            }

            else if(entrada.equals("RF"))
            {
                System.out.println("(R) " + lista.removerFim().getName());
            }
        }

        // ----------------------------------------------------------------- //

        // printar lista flex
        lista.mostrar();

        // ----------------------------------------------------------------- //

        // Close scanner
        inScanner.close();
    }
}

// ---------------------------------------------------------------------------------------------------- //