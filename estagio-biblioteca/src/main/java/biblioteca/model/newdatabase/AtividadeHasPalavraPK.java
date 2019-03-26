package biblioteca.model.newdatabase;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AtividadeHasPalavraPK implements Serializable {

    private Integer atividadeId;

    private Integer palavraId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtividadeHasPalavraPK that = (AtividadeHasPalavraPK) o;
        return Objects.equals(atividadeId, that.atividadeId) &&
                Objects.equals(palavraId, that.palavraId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atividadeId, palavraId);
    }

    public Integer getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Integer atividadeId) {
        this.atividadeId = atividadeId;
    }

    public Integer getPalavraId() {
        return palavraId;
    }

    public void setPalavraId(Integer palavraId) {
        this.palavraId = palavraId;
    }
}
