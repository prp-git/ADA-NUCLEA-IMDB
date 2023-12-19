import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Imdb {
    public static void main(String[] args) {

        ArrayList<Ator> listagemAtores = new ArrayList<>();
        ArrayList<Diretor> listagemDiretores = new ArrayList<>();
        ArrayList<Filme> listagemFilmes = new ArrayList<>();

        System.out.println();
        System.out.println("*************** Bem-vindo a IMDB! ***************");
        System.out.println();

        boolean continua = true;

        while (continua) {
            String cabecalho = "";
            cabecalho +=
                    "Escolha uma opção: \n\n" +
                    "1) Cadastrar filmes |  " +
                    "2) Cadastrar atores |  " +
                    "3) Cadastrar diretores |  " +
                    "4) Associar filme ator diretor |  " +
                    "5) Pesquisar filme |  " +
                    "6) Encerrar aplicação!\n\n" +
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
                    listagemFilmes = Filme.cadastrarFilmeViaTeclado(listagemFilmes);
                    break;

                case 2:
                    listagemAtores = Ator.cadastrarAtor(listagemAtores);
                    break;

                case 3:
                    listagemDiretores = Diretor.cadastrarDiretor(listagemDiretores);
                    break;

                case 4:
                      Filme.associarFilmeAtorDiretor(listagemDiretores, listagemAtores, listagemFilmes);
                    break;

                case 5:
//                    pesquisarFilmePorNome(String trechoNome);
                    Filme.pesquisarFilmePorNome(listagemFilmes);
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


}