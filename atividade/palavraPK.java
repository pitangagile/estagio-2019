package biblioteca.model.atividade;


import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class palavraPK implements Serializable {

    @Column(name = "codigo_palavra")
    private Long codigo_palavra;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        palavraPK palavraPK = (palavraPK) o;
        return Objects.equal(codigo_palavra, palavraPK.codigo_palavra);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo_palavra);
    }

    public Long getCodigo_palavra() {
        return codigo_palavra;
    }

    public void setCodigo_palavra(Long codigo_palavra) {
        this.codigo_palavra = codigo_palavra;
    }
}
