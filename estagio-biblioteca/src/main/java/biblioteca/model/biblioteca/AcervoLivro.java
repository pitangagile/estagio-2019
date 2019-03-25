package biblioteca.model.biblioteca;

import biblioteca.infraestrutura.IObjectPersistent;
import biblioteca.model.Livro;

import javax.persistence.*;

@Entity
@Table(name = "tbacervolivro")
public class AcervoLivro implements IObjectPersistent<AcervoLivroPK> {

    @EmbeddedId
    private AcervoLivroPK acervoLivroPK;


    @ManyToOne
    @MapsId("acervoId")
    @JoinColumn(name = "acervoId")
    private Acervo acervo;


    @ManyToOne
    @MapsId("livroId")
    @JoinColumn(name = "livroId")
    private Livro livro;

    @Override
    public AcervoLivroPK getId() {
        return this.acervoLivroPK;
    }
}


