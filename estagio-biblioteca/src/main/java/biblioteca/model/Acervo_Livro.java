package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbacervo_livro")
public class Acervo_Livro implements IObjectPersistent<Acervo_LivroPK> {

    @EmbeddedId //caso de chave composta
    private Acervo_LivroPK acervoLivroPK;

    @ManyToOne
    @MapsId("acervoId")
    private Acervo acervo;

    @ManyToOne
    @MapsId("livroId")
    private Livro livro;

    @Column(name = "ace_cl_quantidade")
    private Integer quantidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Acervo_Livro that = (Acervo_Livro) o;

        return acervoLivroPK != null ? acervoLivroPK.equals(that.acervoLivroPK) : that.acervoLivroPK == null;
    }

    @Override
    public int hashCode() {
        return acervoLivroPK != null ? acervoLivroPK.hashCode() : 0;
    }

    public Acervo_LivroPK getAcervoLivroPK() {
        return acervoLivroPK;
    }

    public void setAcervoLivroPK(Acervo_LivroPK acervoLivroPK) {
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
    public Acervo_LivroPK getId() {
        return this.acervoLivroPK;
    }
}
