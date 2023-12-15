import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private String nome;
    private String dataNascimento;
    private String paisOrigem;
    protected ArrayList<Filme> filmes = new ArrayList<>();

    public Pessoa() { }

    public Pessoa(String nome, String dataNascimento, String paisOrigem) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.paisOrigem = paisOrigem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome +
                '}';
    }


}
