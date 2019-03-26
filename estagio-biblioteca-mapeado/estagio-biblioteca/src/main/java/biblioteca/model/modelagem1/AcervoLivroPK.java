package biblioteca.model.modelagem1;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AcervoLivroPK implements Serializable {

    private Long acervoId;

    private Long livroId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AcervoLivroPK that = (AcervoLivroPK) o;

        if (acervoId != null ? !acervoId.equals(that.acervoId) : that.acervoId != null) return false;
        return livroId != null ? livroId.equals(that.livroId) : that.livroId == null;
    }

    @Override
    public int hashCode() {
        int result = acervoId != null ? acervoId.hashCode() : 0;
        result = 31 * result + (livroId != null ? livroId.hashCode() : 0);
        return result;
    }

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
}