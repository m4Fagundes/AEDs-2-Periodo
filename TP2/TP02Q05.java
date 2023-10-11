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

public class TP02Q05 {
    public static void main(String[] args) {

        Jogador[] players = new Jogador[3923];
        Scanner scanner = new Scanner(System.in);

        AtualizaCampoVazio();

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


        Jogador[] playesSelessao = new Jogador[1000];
        String id = scanner.nextLine();
        int i = 0;
        int contador=0;
        while (!id.equals("FIM")) {
            try {
                int playerIndex = Integer.parseInt(id);
                if (players[playerIndex] != null) {
                    playesSelessao[i] = new Jogador();
                    playesSelessao[i].setId(players[playerIndex].getId());
                    playesSelessao[i].setNome(players[playerIndex].getNome());
                    playesSelessao[i].setAltura(players[playerIndex].getAltura());
                    playesSelessao[i].setPeso(players[playerIndex].getPeso());
                    playesSelessao[i].setUniversidade(players[playerIndex].getUniversidade());
                    playesSelessao[i].setAnoNascimento(players[playerIndex].getAnoNascimento());
                    playesSelessao[i].setCidadeNascimento(players[playerIndex].getCidadeNascimento());
                    playesSelessao[i].setEstadoNascimento(players[playerIndex].getEstadoNascimento());
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

//algoritmo de ordenacao por selecao
        for (int j = 0; j < contador - 1; j++) {
            int menor = j;
            for (int k = j + 1; k < contador; k++) {
                // Comparação de nomes sem usar compareTo
                if (playesSelessao[menor].getNome().compareTo(playesSelessao[k].getNome()) > 0) {
                    menor = k;
                }
            }
            Jogador temp = playesSelessao[j];
            playesSelessao[j] = playesSelessao[menor];
            playesSelessao[menor] = temp;
        }

        for (int j = 0; j < contador; j++) {
            playesSelessao[j].imprimir();
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
