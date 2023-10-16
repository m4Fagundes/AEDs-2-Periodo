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
        this.cidadeNascimento = cidadeNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
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

public class TP02Q03 {
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


        // pesquisa sequencial por id
        String[] nomesAPesquisar = new String[99];
        String id = scanner.nextLine();
        int i = 0;

        while (!id.equals("FIM") && i < 99) {
            nomesAPesquisar[i] = players[Integer.parseInt(id)].getNome();
            i++;
            id = scanner.nextLine();
        }

// nomes a serem comparados no nomesAPesquisar
        String[] pesquisa = new String[100];
        String nome = scanner.nextLine();
        int j = 0;

        while (!nome.equals("FIM") && j < 100) {
            pesquisa[j] = nome;
            j++;
            nome = scanner.nextLine();
        }

// algoritmo de pesquisa sequencial no vetor nomesAPesquisar
        for (int k = 0; k < j; k++) { // Usamos j, não 100
            boolean encontrado = false;

            for (int l = 0; l < i; l++) { // Usamos i, não 49
                if (pesquisa[k].equals(nomesAPesquisar[l])) {
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
        }


    }
    public static void AtualizaCampoVazio(){
        //String csvArquivo = "C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\players.csv";
        //String novoCsvArquivo = "C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\players_atualizado.csv";
        String csvArquivo = "players.csv";
        String novoCsvArquivo = "players_atualizado.csv";

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
