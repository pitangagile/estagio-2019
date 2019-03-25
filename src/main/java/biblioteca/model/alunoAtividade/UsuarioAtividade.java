package biblioteca.model.alunoAtividade;

import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
@Table(name = "usuario_has_atividade")
public class UsuarioAtividade {

  //Criando id com a chave composta embarcável
  @EmbeddedId
  private UsuarioAtividadePK usuarioAtividadePK;


  //Mapeando a chave composta
  @JoinColumns(value = {@JoinColumn(name = "tipoUsuarioId",insertable = false,updatable = false),
  @JoinColumn(name = "usuarioId",insertable = false,updatable = false)
  },foreignKey = @ForeignKey(name = "FK_USER"))
  @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  private Usuario usuario;

  @ManyToOne()
  @MapsId("atividadeId")
  @JoinColumn(name = "atividadeId")
  private Atividade atividade;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UsuarioAtividade that = (UsuarioAtividade) o;
    return Objects.equal(usuarioAtividadePK, that.usuarioAtividadePK) &&
      Objects.equal(usuario, that.usuario) &&
      Objects.equal(atividade, that.atividade);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(usuarioAtividadePK, usuario, atividade);
  }

  public UsuarioAtividadePK getUsuarioAtividadePK() {
    return usuarioAtividadePK;
  }

  public void setUsuarioAtividadePK(UsuarioAtividadePK usuarioAtividadePK) {
    this.usuarioAtividadePK = usuarioAtividadePK;
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
}
