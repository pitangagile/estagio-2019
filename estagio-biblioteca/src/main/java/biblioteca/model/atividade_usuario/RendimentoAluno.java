package biblioteca.model.atividade_usuario;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_rendimento_aluno")
public class RendimentoAluno implements IObjectPersistent<RendimentoAlunoPK> {

    @EmbeddedId
    private RendimentoAlunoPK rendimentoAlunoPK;

    @JoinColumns(value = {
            @JoinColumn(name = "usuario_tipo_usuario_codigo", referencedColumnName = "tipo_codigo_usuario", insertable = false,updatable = false)})
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;

    @JoinColumns(value = {
            @JoinColumn(name = "atividade_codigo_atividade", referencedColumnName = "codigo_atividade", insertable = false, updatable = false)})
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Atividade atividade;

    @Id
    private Long id_rendimento;

    @Column(name = "rea_cl_codigo_aluno", nullable = false)
    private Long codigo_aluno;

    @Column(name = "rea_cl_codigo_atividade", nullable = false)
    private Long codigo_atividade;

    @Column(name = "rea_cl_data_2", nullable = false)
    private int data_2;

    @Column(name = "rea_cl_hora", nullable = false)
    private int hora;

    @Column(name = "rea_cl_rendimento", nullable = false)
    private double rendimento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendimentoAluno that = (RendimentoAluno) o;
        return data_2 == that.data_2 &&
                hora == that.hora &&
                Double.compare(that.rendimento, rendimento) == 0 &&
                Objects.equals(rendimentoAlunoPK, that.rendimentoAlunoPK) &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(atividade, that.atividade) &&
                Objects.equals(id_rendimento, that.id_rendimento) &&
                Objects.equals(codigo_aluno, that.codigo_aluno) &&
                Objects.equals(codigo_atividade, that.codigo_atividade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rendimentoAlunoPK, usuario, atividade, codigo_aluno, codigo_atividade, data_2, hora, rendimento);
    }

    public RendimentoAlunoPK getRendimentoAlunoPK() {
        return rendimentoAlunoPK;
    }

    public void setRendimentoAlunoPK(RendimentoAlunoPK rendimentoAlunoPK) {
        this.rendimentoAlunoPK = rendimentoAlunoPK;
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

    public Long getId_rendimento() {
        return id_rendimento;
    }

    public void setId_rendimento(Long id_rendimento) {
        this.id_rendimento = id_rendimento;
    }

    public Long getCodigo_aluno() {
        return codigo_aluno;
    }

    public void setCodigo_aluno(Long codigo_aluno) {
        this.codigo_aluno = codigo_aluno;
    }

    public Long getCodigo_atividade() {
        return codigo_atividade;
    }

    public void setCodigo_atividade(Long codigo_atividade) {
        this.codigo_atividade = codigo_atividade;
    }

    public int getData_2() {
        return data_2;
    }

    public void setData_2(int data_2) {
        this.data_2 = data_2;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    @Override
    public RendimentoAlunoPK getId() {
        return this.rendimentoAlunoPK;
    }
}
