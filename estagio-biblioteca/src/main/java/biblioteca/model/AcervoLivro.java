package biblioteca.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_acervo_livro")
public class AcervoLivro implements Serializable {

    @EmbeddedId
    private AcervoLivroPk acervoLivroPk;

    @ManyToOne
    @MapsId("acervoId")
    @JoinColumn(name = "acervoId")
    private Acervo acervo;

    @ManyToOne
    @MapsId("livroId")
    @JoinColumn(name = "livroId")
    private Livro livro;

}
