package biblioteca.utils;

public enum SituacaoEmprestimo {
    NO_PRAZO(0,"no prazo"), EM_ATRASO(1,"Em atraso"), FINALIZADO(2, "Finalizado");

    public int codigo;
    public String descricao;

    SituacaoEmprestimo(int codigo, String descricao) {
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
