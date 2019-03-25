package biblioteca.model.alunoAtividade;


import com.google.common.base.Objects;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UsuarioTipoPK implements Serializable {

  private Integer usuarioId;

  private Integer tipoUsuarioId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UsuarioTipoPK that = (UsuarioTipoPK) o;
    return Objects.equal(usuarioId, that.usuarioId) &&
      Objects.equal(tipoUsuarioId, that.tipoUsuarioId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(usuarioId, tipoUsuarioId);
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
}
