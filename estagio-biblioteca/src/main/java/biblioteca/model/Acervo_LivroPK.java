package biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable //não adiciona nova tabela, mas pode ser parte de outra classe
public class Acervo_LivroPK implements Serializable {

    @Column(name = "ace_cl_acervoid", nullable = false)
    private Long acervoId;

    @Column(name = "ace_cl_livroid", nullable = false)
    private Long livroId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Acervo_LivroPK that = (Acervo_LivroPK) o;

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
