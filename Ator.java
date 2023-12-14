import java.util.ArrayList;
import java.util.List;

public class Ator extends Pessoa {

    public Ator() {
    }

    public Ator(String nome, String dataNascimento, String paisOrigem) {
        super(nome, dataNascimento, paisOrigem);
    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
        if(!filme.elenco.contains(this)) {
            filme.elenco.add(this);
        }
    }

    @Override
    public String toString() {
        return "Ator{} " + super.toString();
    }
}
