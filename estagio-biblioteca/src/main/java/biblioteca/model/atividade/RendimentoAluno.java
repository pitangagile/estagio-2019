package biblioteca.model.atividade;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rendimento_aluno")
public class RendimentoAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rendimento")
    private Long idRendimento;

    @Column(name = "usuario_codigo_usuario")
    private Long usuarioCodigo;

    @Column(name = "usuario_tipo_usuario_codigo")
    private Long tipoUsuarioCodigo;

    @Column(name = "atividade_codigo_atividade")
    private Long atividadeCodigo;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "usuario_codigo_usuario", referencedColumnName = "codigo_usuario", insertable = false, updatable = false),
            @JoinColumn(name = "usuario_tipo_usuario_codigo", referencedColumnName = "tipo_usuario_codigo", insertable = false, updatable = false)
    })
    private Usuario usuario;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "atividade_codigo_atividade", referencedColumnName = "codigo_atividade", insertable = false, updatable = false)
    })
    private Atividade atividade;

    public Long getIdRendimento() {
        return idRendimento;
    }

    public void setIdRendimento(Long idRendimento) {
        this.idRendimento = idRendimento;
    }

    public Long getUsuarioCodigo() {
        return usuarioCodigo;
    }

    public void setUsuarioCodigo(Long usuarioCodigo) {
        this.usuarioCodigo = usuarioCodigo;
    }

    public Long getTipoUsuarioCodigo() {
        return tipoUsuarioCodigo;
    }

    public void setTipoUsuarioCodigo(Long tipoUsuarioCodigo) {
        this.tipoUsuarioCodigo = tipoUsuarioCodigo;
    }

    public Long getAtividadeCodigo() {
        return atividadeCodigo;
    }

    public void setAtividadeCodigo(Long atividadeCodigo) {
        this.atividadeCodigo = atividadeCodigo;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendimentoAluno that = (RendimentoAluno) o;
        return Objects.equals(idRendimento, that.idRendimento) &&
                Objects.equals(usuarioCodigo, that.usuarioCodigo) &&
                Objects.equals(tipoUsuarioCodigo, that.tipoUsuarioCodigo) &&
                Objects.equals(atividadeCodigo, that.atividadeCodigo) &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(atividade, that.atividade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRendimento, usuarioCodigo, tipoUsuarioCodigo, atividadeCodigo, usuario, atividade);
    }

}
