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

    static void associaAtorDiretor (Ator ator, Diretor diretor, Filme filme) {
        filme.adicionarAtor(ator);
        filme.setDiretor(diretor);
    }


    @Override
    public String toString() {
        return "Filme{" + "titulo='" + titulo + "'}'";
    }

    public String mostrarFilme() {
        String linhas = "";
        linhas += "Filme: " + this.getTitulo() + "\n"
                + "Ano: " + this.ano +"\n";
      if (this.diretor != null) {
            linhas += "Diretor: " + this.getDiretor().getNome() +"\n";
        }
        linhas += "Orçamento (MilharesUSD): " + orcamento +"\n"
                + "Elenco: " +"\n";
                for (Ator ator : elenco) {
                    linhas += String.format("%8s%-10s%n","", ator.getNome());
        }
        return linhas;
    }


    public String toString2() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", ano='" + ano + '\'' +
                ", orcamento=" + orcamento +
                ", diretor=" + diretor +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public String toString3() {
        String nomes = "";
        for (Ator ator : elenco) {
            nomes += ator.getNome() + " / ";
        }
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", ano='" + ano + '\'' +
                ", orcamento=" + orcamento +
                ", diretor=" + diretor +
                ", descricao='" + descricao + '\'' +
                ", elenco=" + nomes +
                '}';
    }
}

