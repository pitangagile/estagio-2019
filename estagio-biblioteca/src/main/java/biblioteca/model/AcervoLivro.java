package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;

@Entity
@Table(name = "tb_acervo_livro")
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

        return acervoLivroPK != null ? acervoLivroPK.equals(that.acervoLivroPK) : that.acervoLivroPK == null;
    }

    @Override
    public int hashCode() {
        return acervoLivroPK != null ? acervoLivroPK.hashCode() : 0;
    }

    public AcervoLivroPK getAcervoLivroPK() {
        return acervoLivroPK;
    }

    public void setAcervoLivroPK(AcervoLivroPK acervoLivroPK) {
        this.acervoLivroPK = acervoLivroPK;
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
