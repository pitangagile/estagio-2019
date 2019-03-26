package biblioteca.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class AcervoLivroPK implements Serializable {

    @Column(name = "ace_cl_acervoID",nullable = false)
    private Long acervoId;

    @Column(name = "ace_cl_livroID",nullable = false)
    private Long livroId;


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

    public Long getAcervoId() {
        return acervoId;
    }

    public void setAcervoId(Long acervoID) {
        this.acervoId = acervoID;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroID) {
        this.livroId = livroID;
    }

}
