package biblioteca.Utils;

public enum SituacaoEmprestimo {
    NO_PRAZO(0, "NO PRAZO"), EM_ATRASO(1, "EM ATRASO"), FINALIZADO(2, "FINALIZADO");

    public int codigo;
    public String descricao;

    SituacaoEmprestimo(int codigo, String destricao) {
        this.codigo = codigo;
        this.descricao = destricao;
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
