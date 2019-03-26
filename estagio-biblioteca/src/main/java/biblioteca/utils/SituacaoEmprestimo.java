package biblioteca.utils;

public enum SituacaoEmprestimo {

    //constantes são em caixa alta.

    NO_PRAZO(0,"No Prazo"),EM_ATRASO(1,"Em Atraso"),FINALIZADO(2,"Finalizado");

    public int codigo;
    public String descricao;

    //construtores enum são privados
    SituacaoEmprestimo(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
