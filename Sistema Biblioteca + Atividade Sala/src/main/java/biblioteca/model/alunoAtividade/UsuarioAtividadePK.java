package biblioteca.model.alunoAtividade;

import com.google.common.base.Objects;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UsuarioAtividadePK implements Serializable {


  //Mapeando chave composta, criando um embarcável
  private Integer usuarioId;
  private Integer tipoUsuarioId;
  private Integer atividadeId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UsuarioAtividadePK that = (UsuarioAtividadePK) o;
    return Objects.equal(usuarioId, that.usuarioId) &&
      Objects.equal(tipoUsuarioId, that.tipoUsuarioId) &&
      Objects.equal(atividadeId, that.atividadeId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(usuarioId, tipoUsuarioId, atividadeId);
  }

  public Integer getUsuarioId() {
    return usuarioId;
  }

  public void setUsuarioId(Integer usuarioId) {
    this.usuarioId = usuarioId;
  }

  public Integer getTipoUsuarioId() {
    return tipoUsuarioId;
  }

  public void setTipoUsuarioId(Integer tipoUsuarioId) {
    this.tipoUsuarioId = tipoUsuarioId;
  }

  public Integer getAtividadeId() {
    return atividadeId;
  }

  public void setAtividadeId(Integer atividadeId) {
    this.atividadeId = atividadeId;
  }
}
