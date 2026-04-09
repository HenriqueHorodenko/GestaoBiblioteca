import java.util.ArrayList;

public class Livro {
    private int id_livro;
    private String titulo;
    private String autor;
    private int ano_publicacao;
    private ArrayList<Exemplar> exemplares;

    public Livro(int id_livro, String titulo, String autor, int ano_publicacao) {
        this.id_livro = id_livro;
        this.titulo = titulo;
        this.autor = autor;
        this.ano_publicacao = ano_publicacao;
        this.exemplares = new ArrayList<>();
    }

    public int getIdLivro() {
        return id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return ano_publicacao;
    }

    public ArrayList<Exemplar> getExemplares() {
        return exemplares;
    }

    public void adicionarExemplar(Exemplar e) {
        exemplares.add(e);
    }

    @Override
    public String toString() {
        return "Código: " + id_livro + " | Título: " + titulo + " | Autor: " + autor;
    }
}