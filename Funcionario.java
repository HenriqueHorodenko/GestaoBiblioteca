
public class Funcionario extends Pessoa {
    private int id_funcionario;
    private String email;

    public Funcionario(String nome, String nascimento, String telefone, int id_funcionario) {
        super(nome, nascimento, telefone);
        this.id_funcionario = id_funcionario;
        this.email = id_funcionario + "@biblioteca.com";
        
    }

    public int getId() {
        return id_funcionario;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return super.toString() + " | ID: " + id_funcionario + " | Email: " + email;
    }
}