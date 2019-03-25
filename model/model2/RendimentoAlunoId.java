package biblioteca.model.model2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RendimentoAlunoId implements Serializable {

    @Column(name = "atividade_codigo_atividade",nullable = false)
    private Integer atividade_codigo_atividade;

    @Column(name = "usuario_tipo_usuario_codigo",nullable = false)
    private Integer usuario_tipo_usuario_codigo;

    @Column(name = "usuario_codigo_usuario",nullable = false)
    private Integer usuario_codigo_usuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendimentoAlunoId that = (RendimentoAlunoId) o;
        return Objects.equals(atividade_codigo_atividade, that.atividade_codigo_atividade) &&
                Objects.equals(usuario_tipo_usuario_codigo, that.usuario_tipo_usuario_codigo) &&
                Objects.equals(usuario_codigo_usuario, that.usuario_codigo_usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atividade_codigo_atividade, usuario_tipo_usuario_codigo, usuario_codigo_usuario);
    }

    public Integer getAtividade_codigo_atividade() {
        return atividade_codigo_atividade;
    }

    public void setAtividade_codigo_atividade(Integer atividade_codigo_atividade) {
        this.atividade_codigo_atividade = atividade_codigo_atividade;
    }

    public Integer getUsuario_tipo_usuario_codigo() {
        return usuario_tipo_usuario_codigo;
    }

    public void setUsuario_tipo_usuario_codigo(Integer usuario_tipo_usuario_codigo) {
        this.usuario_tipo_usuario_codigo = usuario_tipo_usuario_codigo;
    }

    public Integer getUsuario_codigo_usuario() {
        return usuario_codigo_usuario;
    }

    public void setUsuario_codigo_usuario(Integer usuario_codigo_usuario) {
        this.usuario_codigo_usuario = usuario_codigo_usuario;
    }
}
