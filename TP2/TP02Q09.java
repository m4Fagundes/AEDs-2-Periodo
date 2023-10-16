import java.io.*;
import java.util.Scanner;
class Jogador {
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        if (nome == null) {
            return "nao informado";
        }
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        if(universidade == null || universidade.equals("") || universidade.equals(" ")) {
            universidade = "nao informado";
        }
        this.universidade = universidade;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        if(cidadeNascimento == null || cidadeNascimento.equals("") || cidadeNascimento.equals(" ")) {
            cidadeNascimento = "nao informado";
        }
        this.cidadeNascimento = cidadeNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        if(estadoNascimento == null || estadoNascimento.equals("") || estadoNascimento.equals(" ")) {
            estadoNascimento = "nao informado";
        }
        this.estadoNascimento = estadoNascimento;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public int compareTo(Jogador outroJogador) {
        return this.getNome().compareTo(outroJogador.getNome());
    }
    void imprimir(){
        System.out.println("["+id+" ## "+nome+" ## "+altura+" ## "+peso+" ## "+anoNascimento+" ## "+universidade+" ## "+cidadeNascimento+" ## "+estadoNascimento+"]");
    }
    void ler(){
        Scanner scanner = new Scanner(System.in);

        //id
        int aux2 = scanner.nextInt();
        scanner.nextLine();
        setId(aux2);

        //player
        String aux = scanner.nextLine();
        setNome(aux);

        //height
        aux2 = scanner.nextInt();
        scanner.nextLine();
        setId(aux2);

        //weight
        aux2 = scanner.nextInt();
        scanner.nextLine();
        setPeso(aux2);

        //college
        aux = scanner.nextLine();
        setUniversidade(aux);

        //born
        aux2 = scanner.nextInt();
        scanner.nextLine();
        setAnoNascimento(aux2);

        //birth city
        aux = scanner.nextLine();
        setCidadeNascimento(aux);

        //birth state
        aux = scanner.nextLine();
        setEstadoNascimento(aux);

    }
    Jogador(){
        this.id = 0;
        this.nome = "";
        this.altura = 0;
        this.peso = 0;
        this.universidade = "";
        this.anoNascimento = 0;
        this.cidadeNascimento = "";
        this.estadoNascimento = "";
    }
    Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento){
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }
    
}

public class TP02Q09 {
    public static void main(String[] args) {

        Jogador[] players = new Jogador[3923]; // objeto que vai receber os jogadores de todo o arquivo
        Jogador[] playesSelessao = new Jogador[1000]; // objeto que recebe os atributos das entradas do verde
        Jogador[] playesAux = new Jogador[1000]; // objeto auxiliar para o mergeSort

        Scanner scanner = new Scanner(System.in);

        int quantidadeEntrada = 0;

        
        AtualizaCampoVazio();
        preencheJogador(players);
        quantidadeEntrada = leitura(players, playesSelessao, scanner);


        //mergeSort(playesSelessao, playesAux, 0, quantidadeEntrada-1);
        //countingSort(playesSelessao, quantidadeEntrada);
        heapsort(playesSelessao, quantidadeEntrada);
        imprimir(playesSelessao, quantidadeEntrada);
        
        scanner.close();
    }

    public static void imprimir(Jogador[] players, int contador){
        for(int i = 0; i < contador; i++){
            players[i].imprimir();
        }
    }

    public static void countingSort(Jogador[] players, int contador) {
        // Encontre o valor máximo da altura para determinar o tamanho do array auxiliar.
        int maior = 0;
        for (int i = 0; i < contador; i++) {
            if (players[i].getAltura() > maior) {
                maior = players[i].getAltura();
            }
        }
    
        // Crie um array auxiliar para contar a ocorrência de cada altura.
        int[] aux = new int[maior + 1];
        for (int i = 0; i < contador; i++) {
            aux[players[i].getAltura()]++;
        }
    
        // Atualize o array auxiliar para conter as posições finais de cada altura.
        for (int i = 1; i <= maior; i++) {
            aux[i] += aux[i - 1];
        }
    
        // Crie um array ordenado com base nas posições finais no array auxiliar.
        Jogador[] ordenado = new Jogador[contador];
        for (int i = contador - 1; i >= 0; i--) {
            ordenado[aux[players[i].getAltura()] - 1] = players[i];
            aux[players[i].getAltura()]--;
        }
    
        // Copie o array ordenado de volta para o array original.
        System.arraycopy(ordenado, 0, players, 0, contador);
    }
    
    // mergesort usando o atributo universidade
    public static void mergeSort(Jogador[] players, Jogador[] playersAux, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergeSort(players, playersAux, esq, meio);
            mergeSort(players, playersAux, meio + 1, dir);
            intercala(players, playersAux, esq, meio, dir);
        }
    }
    public static void intercala(Jogador[] players, Jogador[] playersAux, int esq, int meio, int dir) {
        for (int k = esq; k <= dir; k++) {
            playersAux[k] = players[k];
        }
        int i = esq;
        int j = meio + 1;
        for (int k = esq; k <= dir; k++) {
            if (i > meio) {
                players[k] = playersAux[j++];
            } else if (j > dir) {
                players[k] = playersAux[i++];
            } else if (playersAux[i].getUniversidade().compareTo(playersAux[j].getUniversidade()) < 0) {
                players[k] = playersAux[i++];
            } else if (playersAux[i].getUniversidade().compareTo(playersAux[j].getUniversidade()) > 0) {
                players[k] = playersAux[j++];
            } else if (playersAux[i].getNome().compareTo(playersAux[j].getNome()) < 0) {
                players[k] = playersAux[i++];
            } else {
                players[k] = playersAux[j++];
            }
        }
    }
    public static void heapsort(Jogador[] players, int contador) {
        // Altere o vetor ignorando a posição zero
        Jogador[] players2 = new Jogador[contador + 1];
        for (int i = 0; i < contador; i++) {
            players2[i + 1] = players[i];
        }
        players = players2;
    
        // Construção do heap.
        for (int tamHeap = 2; tamHeap <= contador; tamHeap++) {
            constroi(players, tamHeap);
        }
    
        // Ordenação propriamente dita.
        int tamHeap = contador;
        while (tamHeap > 1) {
            swap(players, 1, tamHeap--);
            reconstroi(players, tamHeap);
        }
    
        // Altere o vetor para voltar à posição zero
        Jogador[] players3 = new Jogador[contador];
        for (int i = 0; i < contador; i++) {
            players3[i] = players[i + 1];
        }
        players = players3;
    }
    
    public static void constroi(Jogador[] players, int tamHeap) {
        for (int i = tamHeap; i > 1 && (players[i].getAltura() > players[i / 2].getAltura()
                || (players[i].getAltura() == players[i / 2].getAltura() && players[i].getNome().compareTo(players[i / 2].getNome()) > 0)); i /= 2) {
            swap(players, i, i / 2);
        }
    }
    
    public static void reconstroi(Jogador[] players, int tamHeap) {
        int i = 1, filho;
        while (i <= (tamHeap / 2)) {
            if (2 * i < tamHeap && (players[2 * i].getAltura() < players[2 * i + 1].getAltura()
                    || (players[2 * i].getAltura() == players[2 * i + 1].getAltura() && players[2 * i].getNome().compareTo(players[2 * i + 1].getNome()) < 0))) {
                filho = 2 * i + 1;
            } else {
                filho = 2 * i;
            }
            if (players[i].getAltura() < players[filho].getAltura()
                    || (players[i].getAltura() == players[filho].getAltura() && players[i].getNome().compareTo(players[filho].getNome()) < 0)) {
                swap(players, i, filho);
                i = filho;
            } else {
                i = tamHeap;
            }
        }
    }
    
    public static void swap(Jogador[] players, int i, int j) {
        Jogador temp = players[i];
        players[i] = players[j];
        players[j] = temp;
    }

    
    public static int leitura(Jogador[] players, Jogador[] playersSelecao, Scanner scanner) {
        int i = 0;
        int contador = 0;
        String id = scanner.nextLine();

        while (!id.equals("FIM")) {
            try {
                int playerIndex = Integer.parseInt(id);
                if (players[playerIndex] != null) {
                    playersSelecao[i] = new Jogador(players[playerIndex].getId(), players[playerIndex].getNome(), players[playerIndex].getAltura(), players[playerIndex].getPeso(), players[playerIndex].getUniversidade(), players[playerIndex].getAnoNascimento(), players[playerIndex].getCidadeNascimento(), players[playerIndex].getEstadoNascimento());
                    i++;
                    contador++;
                } else {
                    System.out.println("Índice de jogador inválido: " + playerIndex);
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro ao converter o valor para um número inteiro.");
            }
            id = scanner.nextLine();
        }
        return contador;
    }

    public static void preencheJogador(Jogador[] players){
        //String csvArquivo = "C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\players_atualizado.csv";
        String csvArquivo = "/tmp/players.csv";
        BufferedReader conteudoCSV = null;

        String linha = "";
        String csvSeparadorCampo = ",";

        try {
            conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
            int i = 0;
            while ((linha = conteudoCSV.readLine()) != null) {
                String[] campos = linha.split(csvSeparadorCampo);
                if(campos[0].equals("id")) continue; // Pula a primeira linha do CSV (cabeçalho

                if(campos.length == 6){
                    Jogador jogador = new Jogador();
                    jogador.setId(Integer.parseInt(campos[0]));
                    jogador.setNome(campos[1]);
                    jogador.setAltura(Integer.parseInt(campos[2]));
                    jogador.setPeso(Integer.parseInt(campos[3]));
                    jogador.setUniversidade(campos[4]);
                    jogador.setAnoNascimento(Integer.parseInt(campos[5]));
                    jogador.setCidadeNascimento("nao informado");
                    jogador.setEstadoNascimento("nao informado");
                    players[i] = jogador;
                    i++;
                } else if(campos.length == 7){
                    Jogador jogador = new Jogador();
                    jogador.setId(Integer.parseInt(campos[0]));
                    jogador.setNome(campos[1]);
                    jogador.setAltura(Integer.parseInt(campos[2]));
                    jogador.setPeso(Integer.parseInt(campos[3]));
                    jogador.setUniversidade(campos[4]);
                    jogador.setAnoNascimento(Integer.parseInt(campos[5]));
                    jogador.setCidadeNascimento(campos[6]);
                    jogador.setEstadoNascimento("nao informado");
                    players[i] = jogador;
                    i++;
                } else if (campos.length == 8) {
                    Jogador jogador = new Jogador();
                    jogador.setId(Integer.parseInt(campos[0]));
                    jogador.setNome(campos[1]);

                    // Verifica e atribui 0 se o campo estiver vazio e não for uma string
                    if(campos[2].isEmpty()) {
                        jogador.setAltura(0);
                    } else {
                        jogador.setAltura(Integer.parseInt(campos[2]));
                    }
                    if(campos[3].isEmpty()) {
                        jogador.setPeso(0);
                    } else {
                        jogador.setPeso(Integer.parseInt(campos[3]));
                    }

                    // Verifica e atribui uma string vazia se o campo estiver vazio e for uma string
                    if(campos[4].isEmpty()) {
                        jogador.setUniversidade("nao informado");
                    } else {
                        jogador.setUniversidade(campos[4]);
                    }
                    if(campos[5].isEmpty()){
                        jogador.setAnoNascimento(0);
                    } else {
                        jogador.setAnoNascimento(Integer.parseInt(campos[5]));
                    }
                    if (campos[6].isEmpty()) {
                        jogador.setCidadeNascimento("nao informado");
                    } else {
                        jogador.setCidadeNascimento(campos[6]);
                    }
                    if (campos[7].isEmpty()) {
                        jogador.setEstadoNascimento("nao informado");
                    } else {
                        jogador.setEstadoNascimento(campos[7]);
                    }
                    players[i] = jogador;
                    i++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Índice fora dos limites: " + e.getMessage());
        } finally {
            if (conteudoCSV != null) {
                try {
                    conteudoCSV.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
                }
            }
        }
    }

    public static void AtualizaCampoVazio(){
        //String csvArquivo = "C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\players.csv";
        //String novoCsvArquivo = "C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\players_atualizado.csv";
        String csvArquivo = "/tmp/players.csv";
        String novoCsvArquivo = "/tmp/players_atualizado.csv";

        try (BufferedReader conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(novoCsvArquivo))) {

            String linha;
            String csvSeparadorCampo = ",";

            while ((linha = conteudoCSV.readLine()) != null) {
                String[] campos = linha.split(csvSeparadorCampo);

                for (int i = 0; i < campos.length; i++) {
                    if (campos[i].trim().isEmpty()) { // Use trim() para remover espaços em branco antes de verificar se está vazio
                        campos[i] = "nao informado";
                    }
                }

                // Recria a linha atualizada
                String linhaAtualizada = String.join(csvSeparadorCampo, campos);
                escritor.write(linhaAtualizada);
                escritor.newLine();
            }

            //System.out.println("Arquivo atualizado com sucesso.");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao ler ou escrever o arquivo.");
        }
    }

}
