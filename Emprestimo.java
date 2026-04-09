import java.time.LocalDate;

public class Emprestimo {
    private Exemplar exemplar;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;

    public Emprestimo(Exemplar exemplar, Usuario usuario, LocalDate dataEmprestimo) {
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(15);
        this.dataDevolucaoReal = null;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void registrarDevolucao() {
        this.dataDevolucaoReal = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Exemplar: " + exemplar.getCodigo() +
               " | Usuário: " + usuario.getNome() +
               " | Empréstimo: " + dataEmprestimo +
               " | Devolução prevista: " + dataDevolucaoPrevista +
               " | Devolvido: " + (dataDevolucaoReal != null ? dataDevolucaoReal : "Não");
    }
}