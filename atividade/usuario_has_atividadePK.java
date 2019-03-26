package biblioteca.model.atividade;


import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class usuario_has_atividadePK implements Serializable {

    @JoinColumn(name = "usuario_tipo_usuario_codigo", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private tipo_usuario tipo_usuario;

    @JoinColumn(name = "usuario_codigo_usuario", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private usuario usuario;

    @JoinColumn(name = "atividade_codigo_atividade", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private atividade atividade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        usuario_has_atividadePK that = (usuario_has_atividadePK) o;
        return Objects.equal(tipo_usuario, that.tipo_usuario) &&
                Objects.equal(usuario, that.usuario) &&
                Objects.equal(atividade, that.atividade);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tipo_usuario, usuario, atividade);
    }

    public biblioteca.model.atividade.tipo_usuario getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(biblioteca.model.atividade.tipo_usuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public biblioteca.model.atividade.usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(biblioteca.model.atividade.usuario usuario) {
        this.usuario = usuario;
    }

    public biblioteca.model.atividade.atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(biblioteca.model.atividade.atividade atividade) {
        this.atividade = atividade;
    }
}
