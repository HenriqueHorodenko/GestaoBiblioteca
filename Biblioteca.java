import java.util.ArrayList;
import java.time.LocalDate;

public class Biblioteca {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Livro> livros;
    private ArrayList<Emprestimo> emprestimos;

    public Biblioteca() {
        usuarios = new ArrayList<>();
        funcionarios = new ArrayList<>();
        livros = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    public void cadastrarUsuario(Usuario u) {
        usuarios.add(u);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void cadastrarFuncionario(Funcionario f) {
        funcionarios.add(f);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public void cadastrarLivro(Livro l) {
        livros.add(l);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public Livro buscarLivro(int codigo) {
        for (Livro l : livros) {
            if (l.getIdLivro() == codigo) {
                return l;
            }
        }
        return null;
    }

    public Exemplar buscarExemplar(int codigoExemplar) {
        for (Livro l : livros) {
            for (Exemplar e : l.getExemplares()) {
                if (e.getCodigo() == codigoExemplar) {
                    return e;
                }
            }
        }
        return null;
    }

    public void cadastrarExemplar(int codigoLivro, Exemplar e) {
        Livro l = buscarLivro(codigoLivro);

        if (l == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        if (buscarExemplar(e.getCodigo()) != null) {
            System.out.println("Erro: Código do exemplar já existe.");
            return;
        }

        l.adicionarExemplar(e);
        System.out.println("Exemplar cadastrado com sucesso!");
    }

    public void listarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    public void listarLivros() {
        for (Livro l : livros) {
            System.out.println(l);
        }
    }

    public void listarFuncionarios() {
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
    }

    public void listarExemplaresDisponiveis(int codigoLivro) {
        Livro l = buscarLivro(codigoLivro);

        if (l == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        for (Exemplar e : l.getExemplares()) {
            if (e.isDisponivel()) {
                System.out.println(e);
            }
        }
    }

    public void realizarEmprestimo(int codExemplar, int idUsuario) {
        Exemplar e = buscarExemplar(codExemplar);

        if (e == null) {
            System.out.println("Exemplar não encontrado.");
            return;
        }

        if (!e.isDisponivel()) {
            System.out.println("Exemplar indisponível.");
            return;
        }

        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.getId() == idUsuario) {
                usuario = u;
                break;
            }
        }

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        Emprestimo emp = new Emprestimo(e, usuario, LocalDate.now());
        emprestimos.add(emp);

        e.setDisponivel(false);
        usuario.adicionarEmprestimo(e);

        System.out.println("Empréstimo realizado com sucesso!");
    }

    public void realizarDevolucao(int codExemplar) {
        for (Emprestimo emp : emprestimos) {
            if (emp.getExemplar().getCodigo() == codExemplar &&
                emp.getDataDevolucaoReal() == null) {

                emp.registrarDevolucao();
                emp.getExemplar().setDisponivel(true);

                System.out.println("Devolução realizada com sucesso!");
                return;
            }
        }

        System.out.println("Empréstimo não encontrado.");
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public ArrayList<Livro> getLivros() {
        return livros;
    }
}