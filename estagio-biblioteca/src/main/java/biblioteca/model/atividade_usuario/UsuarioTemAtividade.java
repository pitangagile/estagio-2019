package biblioteca.model.atividade_usuario;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_usuario_tem_atividade")
public class UsuarioTemAtividade implements IObjectPersistent<UsuarioTemAtividadePk> {

    @EmbeddedId
    private UsuarioTemAtividadePk usuario_tem_atividadePk;

    @JoinColumns(value = {
            @JoinColumn(name = "usuario_codigo_usuario", referencedColumnName = "codigo_usuario",
                    insertable = false, updatable = false),
            @JoinColumn(name = "usuario_tipo_usuario_codigo", referencedColumnName = "tipo_codigo_usuario",
                    insertable = false,updatable = false)})
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;

    @JoinColumns(value = {
            @JoinColumn(name = "atividade_codigo_atividade", referencedColumnName = "codigo_atividade",
                    insertable = false, updatable = false)})
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Atividade atividade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioTemAtividade that = (UsuarioTemAtividade) o;
        return Objects.equals(usuario_tem_atividadePk, that.usuario_tem_atividadePk) &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(atividade, that.atividade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario_tem_atividadePk, usuario, atividade);
    }

    public UsuarioTemAtividadePk getUsuario_tem_atividadePk() {
        return usuario_tem_atividadePk;
    }

    public void setUsuario_tem_atividadePk(UsuarioTemAtividadePk usuario_tem_atividadePk) {
        this.usuario_tem_atividadePk = usuario_tem_atividadePk;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    @Override
    public UsuarioTemAtividadePk getId() {
        return this.usuario_tem_atividadePk;
    }
}
