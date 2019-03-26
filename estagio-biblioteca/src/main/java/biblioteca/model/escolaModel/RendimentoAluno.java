package biblioteca.model.escolaModel;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_rendimentoAluno")
public class RendimentoAluno implements IObjectPersistent<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rendimento;

    /*A tabela de rendimento é composta de outras chaves, pra isso foi necessário usar o joincolumns, pegando novamente
    * usuario e tipo usuario*/
    @JoinColumns(value = {
            @JoinColumn(name = "fk_usu_id",insertable = false,updatable = false),
            @JoinColumn(name = "fk_tipousu_id",insertable = false,updatable = false)
    },foreignKey = @ForeignKey(name = "FK_USU_RENDIMENTO"))
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Usuario usuario;

    // Também é necessário conter o id de atividade na tabela de rendimento
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Atividade atividade;

    @Column(name = "ren_cl_codigoaluno")
    private Integer codigo_aluno;

    @Column(name = "ren_cl_codigoatividade")
    private Integer codigo_atividade;

    @Column(name = "ren_cl_data")
    private Integer data_2;

    @Column(name = "ren_cl_hora")
    private Integer hora;

    @Column(name = "ren_cl_rendimento")
    private Integer rendimento;

    // Equals and hashcodes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendimentoAluno that = (RendimentoAluno) o;
        return Objects.equals(id_rendimento, that.id_rendimento) &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(codigo_atividade, that.codigo_atividade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_rendimento, usuario, codigo_atividade);
    }

    // Getters and setters

    public Integer getId_rendimento() {
        return id_rendimento;
    }

    public void setId_rendimento(Integer id_rendimento) {
        this.id_rendimento = id_rendimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    @Override
    public Integer getId() {
        return null;
    }
}
