package biblioteca.model.escola;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class UsuarioAtividadePK  implements Serializable {


    @Column(name = "usuario_codigo_usuario", nullable = false)
    private Integer codigoUsuario;

    @Column(name = "usuario_tipo_usuario_codigo", nullable = false)
    private Integer tipoUsuario;

    @Column(name = "atividade_codigo_atividade", nullable = false)
    private Integer codigoAtividade;




    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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
        return Objects.equals(codigoUsuario, that.codigoUsuario) &&
                Objects.equals(tipoUsuario, that.tipoUsuario) &&
                Objects.equals(codigoAtividade, that.codigoAtividade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoUsuario, tipoUsuario, codigoAtividade);
    }
}
