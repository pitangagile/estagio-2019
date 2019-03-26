package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_acervo_livro")
public class AcervoLivro implements IObjectPersistent<AcervoLivroPK> {

    @EmbeddedId //embarcando um id dentro dessa classe
    private AcervoLivroPK acervoLivroPK;

    @MapsId("acervoId") //referencia ao campo da chave que traz o valor do acervo
    @ManyToOne(fetch = FetchType.LAZY)
    private Acervo acervo;

    @MapsId("livroId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Livro livro;

    @Column(name = "ali_cl_quantidade")
    private Integer quantidade;


    @Override
    public AcervoLivroPK getId() {
        return this.acervoLivroPK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcervoLivro that = (AcervoLivro) o;
        return Objects.equals(acervoLivroPK, that.acervoLivroPK) &&
                Objects.equals(acervo, that.acervo) &&
                Objects.equals(livro, that.livro) &&
                Objects.equals(quantidade, that.quantidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acervoLivroPK, acervo, livro, quantidade);
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

}
