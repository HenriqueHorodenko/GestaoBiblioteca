import java.util.ArrayList;

public class Usuario extends Pessoa {
    private int id_usuario;
    private String email;
    private ArrayList<Exemplar> livrosEmprestados;

    public Usuario(String nome, String nascimento, String telefone, int id_usuario) {
        super(nome, nascimento, telefone);
        this.id_usuario = id_usuario;
        this.email = id_usuario + "@biblioteca.com";
        this.livrosEmprestados = new ArrayList<>();
    }

    public int getId() {
        return id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Exemplar> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void adicionarEmprestimo(Exemplar e) {
        livrosEmprestados.add(e);
    }

    @Override
    public String toString() {
        return "ID: " + id_usuario + " | Nome: " + getNome() + " | Email: " + email;
    }
}