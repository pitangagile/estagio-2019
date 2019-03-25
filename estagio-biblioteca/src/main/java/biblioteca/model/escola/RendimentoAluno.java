package biblioteca.model.escola;


import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "esc_rendimento_aluno")
public class RendimentoAluno implements IObjectPersistent<Integer> {

    @Id
    @Column(name = "id_rendimento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "atividade_codigo_atividade")
    private Atividade atividade;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumns(value = {
            @JoinColumn(name =  "usuario_codigo_usuario", insertable = false, updatable = false),
            @JoinColumn(name = "usuario_tipo_usuario_codigo", insertable = false, updatable = false)
    },foreignKey = @ForeignKey(name = "FK_RENDIMENTO_USER"))
    private Usuario usuario;


    @Column(name = "codigo_aluno")
    private Integer codigoAluno;

    @Column(name = "codigo_atividade")
    private Integer codigoAtividade;

    @Column(name = "data_2")
    private Integer data2;

    @Column(name = "hora")
    private Integer hora;

    @Column(name = "rendimento")
    private Integer rendimento;

    public void setId(Integer id) {
        this.id = id;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(Integer codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public Integer getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(Integer codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    public Integer getData2() {
        return data2;
    }

    public void setData2(Integer data2) {
        this.data2 = data2;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public Integer getRendimento() {
        return rendimento;
    }

    public void setRendimento(Integer rendimento) {
        this.rendimento = rendimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendimentoAluno that = (RendimentoAluno) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(atividade, that.atividade) &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(codigoAtividade, that.codigoAtividade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, atividade, usuario, codigoAtividade);
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
