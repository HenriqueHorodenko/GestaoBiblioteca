
public class Pessoa{
    private String nome;
    private String  nascimento;
    private String  telefone;

    public Pessoa(String nome, String nascimento, String telefone){
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
    }

    public String getNome(){
        return nome;
    }
    public String getNascimento(){
        return nascimento;
    }
    public String getTelefone(){
        return telefone;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + " | Nascimento: " + nascimento + " | Telefone: " + telefone;
    }
}