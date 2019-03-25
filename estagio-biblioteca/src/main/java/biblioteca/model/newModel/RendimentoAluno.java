package biblioteca.model.newModel;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;

@Entity
@Table(name = "rendimento_aluno")
public class RendimentoAluno implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "codigo_atividade", referencedColumnName = "id")
    private Atividade codigoAtividade;

    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "codigo_Usuario", insertable = false, updatable = false),
            @JoinColumn(name = "codigo_Tipousuario", insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(name = "FK_user_rend"))
    private Usuario usuario;

    @Column(name = "cod_aluno")
    private Integer codAluno;

    @Column(name = "cod_atividade")
    private Integer codAtividade;

    @Column(name = "data2")
    private Integer data2;

    @Column(name = "hora")
    private Integer hora;

    @Column(name = "rendimento")
    private Integer rendimento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RendimentoAluno that = (RendimentoAluno) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Atividade getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(Atividade codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(Integer codAluno) {
        this.codAluno = codAluno;
    }

    public Integer getCodAtividade() {
        return codAtividade;
    }

    public void setCodAtividade(Integer codAtividade) {
        this.codAtividade = codAtividade;
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
    public Long getId() {
        return null;
    }
}
