package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;
import com.google.common.base.Objects;
import io.swagger.models.auth.In;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_acervoLivro")
public class AcervoLivro implements IObjectPersistent<AcervoLivroPK> {

  @EmbeddedId
  private AcervoLivroPK acervoLivroPK;


  @MapsId("acervoId")
  @ManyToOne(fetch = FetchType.LAZY)
  private Acervo acervo;

  @MapsId("livroId")
  @ManyToOne(fetch = FetchType.LAZY)
  private Livro livro;

  @Column(name = "ali_cl_quantidade")
  private Integer quantidade;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AcervoLivro that = (AcervoLivro) o;
    return Objects.equal(acervoLivroPK, that.acervoLivroPK);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(acervoLivroPK);
  }

  public AcervoLivroPK getAcervoLivroPK() {
    return acervoLivroPK;
  }

  public void setAcervoLivroPK(AcervoLivroPK acervoLivroPK) {
    this.acervoLivroPK = acervoLivroPK;
  }

  public Acervo getAcervo() {
    return acervo;
  }

  public void setAcervo(Acervo acervo) {
    this.acervo = acervo;
  }

  public Livro getLivro() {
    return livro;
  }

  public void setLivro(Livro livro) {
    this.livro = livro;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  @Override
  public AcervoLivroPK getId() {
    return this.acervoLivroPK;
  }
}
