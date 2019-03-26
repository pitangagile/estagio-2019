package biblioteca.model.newdatabase;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_rendimento_aluno")
public class Rendimento_aluno implements IObjectPersistent<RendimentoAlunoPK> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rendimento;

    @Embedded
    private RendimentoAlunoPK rendimentoAlunoPK;

    @MapsId("atividadeId")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "atividadeId_FK", insertable = false, updatable = false)
    private Atividade atividade;

    @MapsId("tipo_usuarioId")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioId_FK", insertable = false, updatable = false)
    private Tipo_Usuario tipo_usuario;

    @MapsId("usuarioId")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioId_FK", insertable = false, updatable = false)
    private Usuario usuario;

    @Column(name = "ral_cl_codigo_aluno")
    private Integer codigo_aluno;

    @Column(name = "ral_cl_codigo_atividade")
    private Integer codigo_atividade;

    @Column(name = "ral_cl_data_2")
    private Integer data_2;

    @Column(name = "ral_cl_hora")
    private Integer hora;

    @Column(name = "ral_cl_rendimento")
    private Integer rendimento;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rendimento_aluno that = (Rendimento_aluno) o;
        return Objects.equals(id_rendimento, that.id_rendimento) &&
                Objects.equals(rendimentoAlunoPK, that.rendimentoAlunoPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_rendimento, rendimentoAlunoPK);
    }

    public Integer getCodigo_aluno() {
        return codigo_aluno;
    }

    public void setCodigo_aluno(Integer codigo_aluno) {
        this.codigo_aluno = codigo_aluno;
    }

    public Integer getCodigo_atividade() {
        return codigo_atividade;
    }

    public void setCodigo_atividade(Integer codigo_atividade) {
        this.codigo_atividade = codigo_atividade;
    }

    public Integer getData_2() {
        return data_2;
    }

    public void setData_2(Integer data_2) {
        this.data_2 = data_2;
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
    public RendimentoAlunoPK getId() {
        return null;
    }
}
