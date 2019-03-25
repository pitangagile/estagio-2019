package biblioteca.model;

import com.google.common.base.Objects;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AcervoLivroPK implements Serializable {

  private Long acervoId;

  private Long livroId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AcervoLivroPK that = (AcervoLivroPK) o;
    return Objects.equal(acervoId, that.acervoId) &&
      Objects.equal(livroId, that.livroId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(acervoId, livroId);
  }

  public Long getAcervoId() {
    return acervoId;
  }

  public void setAcervoId(Long acervoId) {
    this.acervoId = acervoId;
  }

  public Long getLivroId() {
    return livroId;
  }

  public void setLivroId(Long livroId) {
    this.livroId = livroId;
  }


}
