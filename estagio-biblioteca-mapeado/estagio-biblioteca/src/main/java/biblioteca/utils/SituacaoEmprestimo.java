package biblioteca.utils;

public enum SituacaoEmprestimo {

    NOPRAZO(0, "No Prazo"), EMATRASO(1, "Em Atraso"), FINALIZADO(2, "Finalizado");

    public int codigo;
    public String descricao;

    SituacaoEmprestimo(int i, String finalizado) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
