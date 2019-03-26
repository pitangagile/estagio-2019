package biblioteca.model;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "novousuario")
public class UsuarioNovo implements Serializable {

    @EmbeddedId
    private UsuarioNovoPK usuarioNovoPK;

    @Column(name = "nome")
    private String nome;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioNovo that = (UsuarioNovo) o;
        return Objects.equal(usuarioNovoPK, that.usuarioNovoPK) &&
                Objects.equal(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(usuarioNovoPK, nome);
    }

    public UsuarioNovoPK getUsuarioNovoPK() {
        return usuarioNovoPK;
    }

    public void setUsuarioNovoPK(UsuarioNovoPK usuarioNovoPK) {
        this.usuarioNovoPK = usuarioNovoPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
