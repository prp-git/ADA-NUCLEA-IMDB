import java.util.ArrayList;
import java.util.Scanner;

public class Imdb {
    public static void main(String[] args) {

        ArrayList<Ator> listagemAtores = new ArrayList<>();
        ArrayList<Diretor> listagemDiretores = new ArrayList<>();
        ArrayList<Filme> listagemFilmes = new ArrayList<>();

        Diretor diretor1 = new Diretor("Victor Fleming","23/02/1889","EUA");
        Diretor diretor2 = new Diretor("Vittorio De Sica", "07/06/1901", "Itália");
        Diretor diretor3 = new Diretor("Walter Salles", "12/04/1956", "Brasil");
        Diretor diretor4 = new Diretor("Steven Spielberg", "18/12/1946", "EUA");
        listagemDiretores.add(diretor1);
        listagemDiretores.add(diretor2);
        listagemDiretores.add(diretor3);
        listagemDiretores.add(diretor4);

        Ator ator1 = new Ator("Paulo", "20/07/1968","Brasil");
        Ator ator2 = new Ator("Judy Garland", "10/06/1922","EUA");
        Ator ator3 = new Ator("Sophia Loren", "20/09/1934","Itália");
        Ator ator4 = new Ator("Fernanda Montenegro", "16/10/1929", "Brasil");
        Ator ator5 = new Ator("Drew Barrymore", "22/02/1975","EUA");
        listagemAtores.add(ator1);
        listagemAtores.add(ator2);
        listagemAtores.add(ator3);
        listagemAtores.add(ator4);
        listagemAtores.add(ator5);


        Filme filme1 = new Filme("O mágico de Oz", diretor1, "1939", 2.8, "Filme norte-americano de fantasia");
        Filme filme2 = new Filme("A Star Is Born", diretor1, "1954", 5.0,"Musical norte-americano de 1954");
        Filme filme3 = new Filme("Duas Mulheres", diretor2, "1960",0.850,"Segunda Guerra");
        Filme filme4 = new Filme("Central do Brasil", diretor3, "1998", 2.9, "Dora escreve cartas!");
        Filme filme5 = new Filme("E.T. O Extraterrestre", diretor4, "1982", 10.5, "EUA");
        listagemFilmes.add(filme1);
        listagemFilmes.add(filme2);
        listagemFilmes.add(filme3);
        listagemFilmes.add(filme4);
        listagemFilmes.add(filme5);


//        System.out.println("AAAAAAAA");
//
//        System.out.print("Entre com o texto: ");
//        System.out.println("Voce digitou: " + receberStringTeclado());
//        System.out.print("Entre com o valor: ");
//        System.out.println("Voce digitou: " + receberDoubleTeclado());
        String cabecalho = "";
        cabecalho += "Bem-vindo a IMDB!\n" +
                "Escolha uma opção: \n" +
                "1) - Cadastrar filmes\n" +
                "2) - Cadastrar atores\n" +
                "3) - Cadastrar diretores\n" +
                "4) - Associar um filme com seus atores e diretores\n" +
                "5) - Pesquisar filme cadastrado pelo nome\n\n" +
                "Escolha >> ";

        System.out.print(cabecalho);
        int opcao = receberInteiroTeclado();

        switch (opcao) {
            case 1:
                System.out.println("Informe os dados do filme:");
                System.out.print("Título: ");
                String titulo = receberStringTeclado();
                System.out.print("Ano: ");
                String ano = receberStringTeclado();
                System.out.print("Orçamento: ");
                double orcamento = receberDoubleTeclado();


                break;
            case 2:
                System.out.println("Informe os dados do ator:");
                System.out.print("Nome: ");
                String nome = receberStringTeclado();
                System.out.print("Data de nascimento: ");
                String dataNascimento = receberStringTeclado();
                System.out.print("País de origem: ");
                String paisOrigem = receberStringTeclado();
                Ator ator = new Ator(nome, dataNascimento, paisOrigem);
                listagemAtores.add(ator);

                break;
            case 3:
                System.out.println("Informe os dados do diretor:");
                System.out.print("Nome: ");
                nome = receberStringTeclado();
                System.out.print("Data de nascimento: ");
                dataNascimento = receberStringTeclado();
                System.out.print("País de origem: ");
                paisOrigem = receberStringTeclado();
                Diretor diretor = new Diretor(nome, dataNascimento, paisOrigem);
                listagemDiretores.add(diretor);
                break;
            case 4:
                System.out.println("Os diretores listados são:");
                int i=0;
                for (Diretor dir : listagemDiretores) {
                    System.out.println("#" + i + ": " + dir.getNome());
                    i++;
                }
                System.out.println("Qual o índice do diretor: ");
                int indiceDiretor = receberInteiroTeclado();

                System.out.println(listagemDiretores.get(indiceDiretor).getNome());

                System.out.println("Atores listados:");
                int j=0;
                for (Ator at : listagemAtores) {
                    System.out.println("#" + j + ": " + at.getNome());
                    j++;
                }
                System.out.println("Qual o índice do diretor: ");
                int indiceAtor = receberInteiroTeclado();
                System.out.println(listagemAtores.get(indiceAtor).getNome());

                System.out.println("Filmes listados:");
                int k=0;
                for (Filme film : listagemFilmes) {
                    System.out.println("#" + k + ": " + film.getTitulo());
                    k++;
                }
                System.out.println("Qual o índice do filme: ");
                int indiceFilme = receberInteiroTeclado();

                associaAtorDiretor(listagemAtores.get(indiceAtor), listagemDiretores.get(indiceDiretor),listagemFilmes.get(indiceFilme) );

                break;
            case 5:
                System.out.print("Pesquisa pelo nome - Informe o nome procurado...");
                String nomeProcurado = receberStringTeclado().toUpperCase();
                for (int l = 0; l < listagemFilmes.size() ; l++) {
                    if(listagemFilmes.get(l).getTitulo().toUpperCase().contains(nomeProcurado.toUpperCase())) {
                        boolean encontrado = true;
                        System.out.println("Match na posição #" + l + " da listagem de filmes >> " + listagemFilmes.get(l).getTitulo());
                    }
                }

                break;


        }
//        System.out.println(filme1.mostrarFilme());
    }

    private static int receberInteiroTeclado() {
        Scanner sc = new Scanner(System.in);
        int informacao = sc.nextInt();

        return informacao;
    }

    private static String receberStringTeclado() {
        Scanner sc = new Scanner(System.in);
        String informacao = sc.next();

//        sc.close();
        return informacao;
    }

    private static double receberDoubleTeclado() {
        Scanner sc = new Scanner(System.in);
        double informacao = sc.nextDouble();

//            sc.close();
        return informacao;
    }

    private static void associaAtorDiretor (Ator ator, Diretor diretor, Filme filme) {
        filme.adicionarAtor(ator);
        filme.setDiretor(diretor);
    }
}
