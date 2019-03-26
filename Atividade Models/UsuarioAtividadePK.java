package biblioteca.model.Atividades;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class UsuarioAtividadePK implements Serializable {

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

        UsuarioAtividadePK that = (UsuarioAtividadePK) o;

        if (codigoUsuario != null ? !codigoUsuario.equals(that.codigoUsuario) : that.codigoUsuario != null)
            return false;
        if (codigoTipoUsuario != null ? !codigoTipoUsuario.equals(that.codigoTipoUsuario) : that.codigoTipoUsuario != null)
            return false;
        return codigoAtividade != null ? codigoAtividade.equals(that.codigoAtividade) : that.codigoAtividade == null;
    }

    @Override
    public int hashCode() {
        int result = codigoUsuario != null ? codigoUsuario.hashCode() : 0;
        result = 31 * result + (codigoTipoUsuario != null ? codigoTipoUsuario.hashCode() : 0);
        result = 31 * result + (codigoAtividade != null ? codigoAtividade.hashCode() : 0);
        return result;
    }
}
