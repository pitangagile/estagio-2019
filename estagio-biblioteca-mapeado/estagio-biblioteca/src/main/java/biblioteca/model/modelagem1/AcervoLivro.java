package biblioteca.model.modelagem1;

import biblioteca.infraestrutura.IObjectPersistent;
import javax.persistence.*;

@Entity
@Table(name = "tb_acervolivro")
public class AcervoLivro implements IObjectPersistent<AcervoLivroPK> {

    @EmbeddedId
    private AcervoLivroPK acervoLivroPK;

    @ManyToOne
    @MapsId("acervoId")
    private Acervo acervo;

    @ManyToOne
    @MapsId("livroId")
    private Livro livro;

    @Column(name = "aceli_cl_quantidade")
    private Integer quantidade;

    @Override
    public AcervoLivroPK getId() {
        return this.acervoLivroPK;
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