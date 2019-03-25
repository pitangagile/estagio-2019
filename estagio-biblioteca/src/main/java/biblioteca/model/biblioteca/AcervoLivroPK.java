package biblioteca.model.biblioteca;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AcervoLivroPK  implements Serializable {



    @Column(name = "ace_cl_aervo_id", nullable = false)
    private Long acervoId;


    @Column(name = "ace_cl_livro_id", nullable = false)
    private Long livroId;

    public Long getAcervoId() {
        return acervoId;
    }

    public void setAcervoId(Long acervoId) {
        this.acervoId = acervoId;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcervoLivroPK that = (AcervoLivroPK) o;
        return Objects.equals(acervoId, that.acervoId) &&
                Objects.equals(livroId, that.livroId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acervoId, livroId);
    }
}
