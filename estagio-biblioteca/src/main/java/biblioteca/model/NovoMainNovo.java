package biblioteca.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "novonovo")
public class NovoMainNovo implements Serializable {

    @EmbeddedId
    private NovoMainNovoPK novoMainNovoPK;

    @Column(name = "outrod")
    private String outrod;

    @Transient
    private String calor;

    @JoinColumns(value = {
            @JoinColumn(name = "tipo", insertable = false, updatable = false),
            @JoinColumn(name = "codigo", insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(name = "FK_USER"))
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private UsuarioNovo usuarioNovo;


    public NovoMainNovoPK getNovoMainNovoPK() {
        return novoMainNovoPK;
    }

    public void setNovoMainNovoPK(NovoMainNovoPK novoMainNovoPK) {
        this.novoMainNovoPK = novoMainNovoPK;
    }

    public String getOutrod() {
        return outrod;
    }

    public void setOutrod(String outrod) {
        this.outrod = outrod;
    }
}
