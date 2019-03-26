package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;
import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
@Table(name = "tb_acervo_livro", schema = "biblioteca" )
public class AcervoLivro implements IObjectPersistent<AcervoLivroPK> {

    @EmbeddedId
    private AcervoLivroPK acervoLivroPK;

    @MapsId("acervoId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acervoId")
    private Acervo acervos;

    @MapsId("livroId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livroId")
    private Livro livro;

    @Column(name = "acl_cl_quantidade")
    private Integer quantidade;

    public AcervoLivroPK getAcervoLivroPK() {
        return acervoLivroPK;
    }

    public void setAcervoLivroPK(AcervoLivroPK acervoLivroPK) {
        this.acervoLivroPK = acervoLivroPK;
    }

    public Acervo getAcervos() {
        return acervos;
    }

    public void setAcervos(Acervo acervos) {
        this.acervos = acervos;
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

    @Override
    public AcervoLivroPK getId() {
        return this.acervoLivroPK;
    }
}
