package biblioteca.model.alunoAtividade;

import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
@Table(name = "tb_rendimentoAluno")
public class RendimentoAluno {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id_rendimento;

  //Embarcando uma chave composta em outra chave composta
  @JoinColumns(value = {@JoinColumn(name = "tipoUsuarioId",insertable = false,updatable = false),
    @JoinColumn(name = "usuarioId",insertable = false,updatable = false)
  },foreignKey = @ForeignKey(name = "FK_USER_RENDIMENTO"))
  @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  private Usuario usuario;


  @ManyToOne()
  @MapsId("atividadeId")
  @JoinColumn(name = "atividadeId")
  private Atividade atividade;

  private Integer codigo_aluno;

  private Integer codigo_atividade;

  private Integer data_2;

  private Integer hora;

  private Integer rendimento;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RendimentoAluno that = (RendimentoAluno) o;
    return Objects.equal(id_rendimento, that.id_rendimento);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id_rendimento);
  }

  public Integer getId_rendimento() {

    return id_rendimento;
  }

  public void setId_rendimento(Integer id_rendimento) {
    this.id_rendimento = id_rendimento;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Atividade getAtividade() {
    return atividade;
  }

  public void setAtividade(Atividade atividade) {
    this.atividade = atividade;
  }

  public Integer getCodigo_aluno() {
    return codigo_aluno;
  }

  public void setCodigo_aluno(Integer codigo_aluno) {
    this.codigo_aluno = codigo_aluno;
  }

  public Integer getCodigo_atividade() {
    return codigo_atividade;
  }

  public void setCodigo_atividade(Integer codigo_atividade) {
    this.codigo_atividade = codigo_atividade;
  }

  public Integer getData_2() {
    return data_2;
  }

  public void setData_2(Integer data_2) {
    this.data_2 = data_2;
  }

  public Integer getHora() {
    return hora;
  }

  public void setHora(Integer hora) {
    this.hora = hora;
  }

  public Integer getRendimento() {
    return rendimento;
  }

  public void setRendimento(Integer rendimento) {
    this.rendimento = rendimento;
  }
}
