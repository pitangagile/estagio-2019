package biblioteca.model.atividade;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioAtividadePK implements Serializable {

    @Column(name = "usuario_codigo_usuario")
    private Long usuarioCodigo;

    @Column(name = "usuario_tipo_usuario_codigo")
    private Long tipoUsuarioCodigo;

    @Column(name = "atividade_codigo_atividade")
    private Long atividadeCodigo;

    public UsuarioAtividadePK(){

    }

    public Long getUsuarioCodigo() {
        return usuarioCodigo;
    }

    public Long getTipoUsuarioCodigo() {
        return tipoUsuarioCodigo;
    }

    public Long getAtividadeCodigo() {
        return atividadeCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioAtividadePK that = (UsuarioAtividadePK) o;
        return Objects.equals(usuarioCodigo, that.usuarioCodigo) &&
                Objects.equals(tipoUsuarioCodigo, that.tipoUsuarioCodigo) &&
                Objects.equals(atividadeCodigo, that.atividadeCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioCodigo, tipoUsuarioCodigo, atividadeCodigo);
    }
}
