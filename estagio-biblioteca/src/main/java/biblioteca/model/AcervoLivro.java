package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;

@Entity
@Table(name = "tb_acervo_livro")
public class AcervoLivro implements IObjectPersistent<AcervoLivro> {

    @EmbeddedId
    private AcervoLivroPK acervoLivroPK;
    @ManyToOne
    @MapsId("al_cl_livro")
    private Livro livro;

    @ManyToOne
    @MapsId("al_cl_acervo")
    private Acervo acervo;

    @Column(name = "al_cl_quantidade")
    private Integer quantidade;

    @Override
    public AcervoLivro getId() {
        return null;
    }
}
