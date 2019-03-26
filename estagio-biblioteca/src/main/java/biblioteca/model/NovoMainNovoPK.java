package biblioteca.model;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class NovoMainNovoPK implements Serializable {

    @Column(name = "tipo")
    private  Long tipo;

    @Column(name = "codigo")
    private  Long codigo;

    @Column(name = "outro")
    private Long outro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NovoMainNovoPK that = (NovoMainNovoPK) o;
        return Objects.equal(tipo, that.tipo) &&
                Objects.equal(codigo, that.codigo) &&
                Objects.equal(outro, that.outro);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tipo, codigo, outro);
    }

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long tipo) {
        this.tipo = tipo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getOutro() {
        return outro;
    }

    public void setOutro(Long outro) {
        this.outro = outro;
    }
}
