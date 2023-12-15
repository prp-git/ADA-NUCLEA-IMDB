import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Imdb {
    public static void main(String[] args) {

        ArrayList<Ator> listagemAtores = new ArrayList<>();
        ArrayList<Diretor> listagemDiretores = new ArrayList<>();
        ArrayList<Filme> listagemFilmes = new ArrayList<>();

        System.out.println("Bem-vindo a IMDB!");

        boolean continua = true;

        while (continua) {
            String cabecalho = "";
            cabecalho +=
                    "Escolha uma opção: \n" +
                    "1) - Cadastrar filmes |  " +
                    "2) - Cadastrar atores |  " +
                    "3) - Cadastrar diretores |  " +
                    "4) - Associar ao filme atores e diretores |  " +
                    "5) - Pesquisar filme |  " +
                    "6) - Encerrar aplicação!\n" +
                    "Escolha >> ";

            System.out.print(cabecalho);
            int opcao = receberInteiroTeclado();
            if (opcao == 0) {
                System.out.println("Fim de operações!");
                continua = false;
                break;
            }

            switch (opcao) {
                case 1:
                    listagemFilmes = cadastrarFilmeViaTeclado(listagemFilmes);
                    break;

                case 2:
                    listagemAtores = Ator.cadastrarAtor(listagemAtores);
                    break;

                case 3:
                    listagemDiretores = Diretor.cadastrarDiretor(listagemDiretores);
                    break;

                case 4:
                    System.out.println("Os diretores listados são:");
                    int i = 0;
                    for (Diretor dir : listagemDiretores) {
                        System.out.println("#" + i + ": " + dir.getNome());
                        i++;
                    }
                    System.out.println("Qual o índice do diretor: ");
                    int indiceDiretor = receberInteiroTeclado();

                    System.out.println(listagemDiretores.get(indiceDiretor).getNome());

                    System.out.println("Atores listados:");
                    int j = 0;
                    for (Ator at : listagemAtores) {
                        System.out.println("#" + j + ": " + at.getNome());
                        j++;
                    }
                    System.out.println("Qual o índice do ator: ");
                    int indiceAtor = Imdb.receberInteiroTeclado();
                    System.out.println(listagemAtores.get(indiceAtor).getNome());

                    System.out.println("Filmes listados:");
                    int k = 0;
                    for (Filme film : listagemFilmes) {
                        System.out.println("#" + k + ": " + film.getTitulo());
                        k++;
                    }
                    System.out.println("Qual o índice do filme: ");
                    int indiceFilme = Imdb.receberInteiroTeclado();

                    Filme.associaAtorDiretor(listagemAtores.get(indiceAtor), listagemDiretores.get(indiceDiretor), listagemFilmes.get(indiceFilme));

                    break;

                case 5:
                    System.out.print("Pesquisa pelo nome - Informe o nome procurado OU * para ver todos >> ");
                    String nomeProcurado = receberStringTeclado().toUpperCase();

                    if (!nomeProcurado.equals("*")) {
                        for (int l = 0; l < listagemFilmes.size(); l++) {
                            if (listagemFilmes.get(l).getTitulo().toUpperCase().contains(nomeProcurado.toUpperCase())) {
                                boolean encontrado = true;
                                String texto = listagemFilmes.get(l).mostrarFilme();
                                System.out.println(texto);
//                                System.out.println("Match na posição #" + l + " da listagem de filmes >> " + listagemFilmes.get(l).getTitulo());
                            }
                        }
                    } else {
                        System.out.println("Filmes:");
                        for (int l = 0; l < listagemFilmes.size(); l++) {
//                            System.out.println("#" + l + " da listagem de filmes >> " + listagemFilmes.get(l).getTitulo());
                            String texto = listagemFilmes.get(l).mostrarFilme();
                            System.out.println(texto);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Aplicação encerrada!");
                    continua = false;
                    break;
            }
        }
    }

    public static int receberInteiroTeclado() {
        try {
            Scanner sc = new Scanner(System.in);
            int informacao = sc.nextInt();
            return informacao;
        }
        catch (InputMismatchException ex) {
            System.out.println("Valor incorreto: entre com um inteiro");
            return 0;
        }
    }

    public static String receberStringTeclado() {
        Scanner sc = new Scanner(System.in);
        String informacao = sc.next();
        return informacao;
    }

    public static double receberDoubleTeclado() {
        try {
            Scanner sc = new Scanner(System.in);
            double informacao = sc.nextDouble();
            return informacao;}
        catch (InputMismatchException ex) {
            System.out.println("Valor incorreto: entre com um Double");
            return 0.0;
        }
    }

    public static ArrayList<Filme> cadastrarFilmeViaTeclado(ArrayList<Filme> listagemFilmes) {
        System.out.println("Informe os dados do filme:");
        System.out.print("Título: ");
        String titulo = Imdb.receberStringTeclado();
        System.out.print("Ano: ");
        String ano = Imdb.receberStringTeclado();
        System.out.print("Orçamento: ");
        double orcamento = Imdb.receberDoubleTeclado();
        System.out.print("Descricão: ");
        String descricao = Imdb.receberStringTeclado();

        Filme filme = new Filme(titulo, ano, orcamento, descricao);
        listagemFilmes.add(filme);
        return listagemFilmes;
    }
}