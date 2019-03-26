package biblioteca.utils;

public enum SituacaoEmprestimo {

    NO_PRAZO(0,"No prazo"),
    EM_ATRASO(1,"Em Atraso"),
    FINALIZADO(2,"Finalizado");

    private int codigo;
    private String descricao;

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