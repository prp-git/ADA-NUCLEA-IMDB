import java.util.ArrayList;
import java.util.List;

public class Diretor extends Pessoa {

    Diretor(){
        super();
    }

    protected static ArrayList<Diretor> cadastrarDiretor(ArrayList<Diretor> listagemDiretores) {
        System.out.println("Informe os dados do diretor:");
        System.out.print("Nome: ");
        String nome = Imdb.receberStringTeclado();
        System.out.print("Data de nascimento: ");
        String dataNascimento = Imdb.receberStringTeclado();
        System.out.print("País de origem: ");
        String paisOrigem = Imdb.receberStringTeclado();

        Diretor diretor = new Diretor(nome, dataNascimento, paisOrigem);

        listagemDiretores.add(diretor);

        return listagemDiretores;
    }

    public Diretor(String nome, String dataNascimento, String paisOrigem) {
        super(nome, dataNascimento, paisOrigem);
    }


}
