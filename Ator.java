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

    protected static ArrayList<Ator>  cadastrarAtor(ArrayList<Ator> listagemAtores) {
        System.out.println("Informe os dados do ator:");
        System.out.print("Nome: ");
        String nome = Imdb.receberStringTeclado();
        System.out.print("Data de nascimento: ");
        String dataNascimento = Imdb.receberStringTeclado();
        System.out.print("País de origem: ");
        String paisOrigem = Imdb.receberStringTeclado();
        Ator ator = new Ator(nome, dataNascimento, paisOrigem);
        listagemAtores.add(ator);

        return listagemAtores;
    }

    @Override
    public String toString() {
        return "Ator{} " + super.toString();
    }
}
