package biblioteca.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AcervoLivroPK implements Serializable {

    @Column(name = "pk_cl_livroId", nullable = false)
    private Long livro;
    @Column(name = "pk_cl_acervoId", nullable = false)
    private Long acervo;


}
