package biblioteca.model.model2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioHasAtividadeId implements Serializable {

    @Column(name = "usuario_codigo_usuario",nullable = false)
    private Integer codigoUsuario;

    @Column(name = "usuario_tipo_usuario_codigo",nullable = false)
    private Integer codigoTipoUsuario;

    @Column(name = "atividade_codigo_atividade",nullable = false)
    private Integer codigoAtividade;

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Integer getCodigoTipoUsuario() {
        return codigoTipoUsuario;
    }

    public void setCodigoTipoUsuario(Integer codigoTipoUsuario) {
        this.codigoTipoUsuario = codigoTipoUsuario;
    }

    public Integer getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(Integer codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioHasAtividadeId that = (UsuarioHasAtividadeId) o;
        return Objects.equals(codigoUsuario, that.codigoUsuario) &&
                Objects.equals(codigoTipoUsuario, that.codigoTipoUsuario) &&
                Objects.equals(codigoAtividade, that.codigoAtividade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoUsuario, codigoTipoUsuario, codigoAtividade);
    }
}
