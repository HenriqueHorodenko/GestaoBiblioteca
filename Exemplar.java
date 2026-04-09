public class Exemplar {
    private int codigo;
    private boolean disponivel;

    public Exemplar(int codigo) {
        this.codigo = codigo;
        this.disponivel = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Exemplar: " + codigo + " | Disponível: " + disponivel;
    }
}