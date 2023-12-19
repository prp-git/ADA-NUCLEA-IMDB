import java.util.ArrayList;
import java.util.List;

public class Filme {
    private String titulo;
    private String ano;
    private static double orcamento;
    protected Diretor diretor;
    private String descricao;

    protected static ArrayList<Ator> elenco = new ArrayList<>();

    public Filme() {
    }

    public Filme(String titulo, String ano, double orcamento, String descricao) {
        this.titulo = titulo;
        this.ano = ano;
        this.orcamento = orcamento;
        this.descricao = descricao;
    }

    public Filme(String titulo, Diretor diretor, String ano, double orcamento, String descricao) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.ano = ano;
        this.orcamento = orcamento;
        this.descricao = descricao;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void adicionarAtor(Ator ator) {
        elenco.add(ator);
    }

    static void associaAtorDiretor(Ator ator, Diretor diretor, Filme filme) {
        filme.adicionarAtor(ator);
        filme.setDiretor(diretor);
    }

    public static ArrayList<Filme> cadastrarFilmeViaTeclado(ArrayList<Filme> listagemFilmes) {

        boolean repete = true;
        System.out.println("Informe os dados do filme:");
        System.out.print("Título: ");
        while (repete) {
            String titulo = Imdb.receberStringTeclado();
            repete = false;
            for (Filme filme : listagemFilmes) {
                if (titulo.equals(filme.titulo)) {
                    System.out.println("Título já cadastrado! Digite um novo título...");
                    repete = true;
                    break;
                }
            }
            if (!repete) {
                System.out.print("Ano: ");
                String ano = Imdb.receberStringTeclado();
                System.out.print("Orçamento: ");
                double orcamento = Imdb.receberDoubleTeclado();
                System.out.print("Descricão: ");
                String descricao = Imdb.receberStringTeclado();

                Filme filme = new Filme(titulo, ano, orcamento, descricao);
                listagemFilmes.add(filme);
                repete = false;
            }
        }
        return listagemFilmes;
    }

    String mostrarFilme() {
        String linhas = "";
        linhas += "Filme: " + this.getTitulo() + "\n"
                + "Ano: " + this.ano + "\n";
        if (this.diretor != null) {
            linhas += "Diretor: " + this.getDiretor().getNome() + "\n";
        }
        linhas += "Orçamento (MilharesUSD): " + orcamento + "\n"
                + "Elenco: " + "\n";
        for (Ator ator : elenco) {
            linhas += String.format("%8s%-10s%n", "", ator.getNome());
        }
        return linhas;
    }

    public static void associarFilmeAtorDiretor(ArrayList<Diretor> listagemDiretores, ArrayList<Ator> listagemAtores, ArrayList<Filme> listagemFilmes) {
        boolean faltaComponente = true;
        while (faltaComponente) {
            if (listagemAtores.size() == 0 || listagemDiretores.size() == 0 || listagemFilmes.size() == 0) {
                faltaComponente = true;
                break;
            }
            faltaComponente = false;
            System.out.println("Os diretores listados são:");
            int i = 0;
            for (Diretor dir : listagemDiretores) {
                System.out.println("#" + i + ": " + dir.getNome());
                i++;
            }
            int indiceDiretor = 0;
            boolean invalido = true;
            while (invalido) {
                System.out.println("Qual o índice do diretor: ");
                indiceDiretor = Imdb.receberInteiroTeclado();
                if (indiceDiretor >= listagemDiretores.size()) {
                    System.out.println("Índice inválido para diretor! Digite novamente...");
                } else {
                    invalido = false;
                }
            }

            System.out.println(listagemDiretores.get(indiceDiretor).getNome());

            System.out.println("Atores listados:");
            int j = 0;
            for (Ator at : listagemAtores) {
                System.out.println("#" + j + ": " + at.getNome());
                j++;
            }
            int indiceAtor = 0;
            invalido = true;
            while (invalido) {
                System.out.print("Informe o índice do ator: ");
                indiceAtor = Imdb.receberInteiroTeclado();
                if (indiceAtor >= listagemAtores.size()) {
                    System.out.println("Índice inválido para ator! Digite novamente...");
                } else {
                    invalido = false;
                }
            }
            System.out.println(listagemAtores.get(indiceAtor).getNome());

            System.out.println("Filmes listados:");
            int k = 0;
            for (Filme film : listagemFilmes) {
                System.out.println("#" + k + ": " + film.getTitulo());
                k++;
            }

            int indiceFilme = 0;
            invalido = true;
            while (invalido) {
                System.out.print("Informe o índice do filme: ");
                indiceFilme = Imdb.receberInteiroTeclado();
                if (indiceFilme >= listagemFilmes.size()) {
                    System.out.println("Índice inválido para filme! Digite novamente...");
                } else {
                    invalido = false;
                }
            }

            Filme.associaAtorDiretor(listagemAtores.get(indiceAtor), listagemDiretores.get(indiceDiretor), listagemFilmes.get(indiceFilme));
        }
        if (faltaComponente) {
            System.out.println("Lista de Atores, Diretores e/ou Filmes VAZIA(S)! Cadastre primeiramente!");
        }
    }

    public static void pesquisarFilmePorNome(ArrayList<Filme> listagemFilmes) {
        System.out.print("Pesquisa pelo nome - Informe o nome procurado OU * para ver todos >> ");
        String nomeProcurado = Imdb.receberStringTeclado().toUpperCase();

        if (!nomeProcurado.equals("*")) {
            for (int l = 0; l < listagemFilmes.size(); l++) {
                if (listagemFilmes.get(l).getTitulo().toUpperCase().contains(nomeProcurado.toUpperCase())) {
                    boolean encontrado = true;
                    String texto = listagemFilmes.get(l).mostrarFilme();
                    System.out.println(texto);
                }
            }
        } else {
            System.out.println("Filmes:");
            if (listagemFilmes.size() == 0) {
                System.out.println("Nenhum filme na lista nesse momento!\n\n");
            } else {
                for (int l = 0; l < listagemFilmes.size(); l++) {
                    String texto = listagemFilmes.get(l).mostrarFilme();
                    System.out.println(texto);
                }
            }
        }

    }

    @Override
    public String toString() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}
