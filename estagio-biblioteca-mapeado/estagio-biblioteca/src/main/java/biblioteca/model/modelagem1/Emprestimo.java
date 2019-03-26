package biblioteca.model.modelagem1;

import biblioteca.infraestrutura.IObjectPersistent;
import biblioteca.utils.SituacaoEmprestimo;
import com.google.common.base.Objects;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_cl_id")
    private Long id;

    @OneToOne(mappedBy = "emprestimo")
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinTable(name = "tb_emprestimo_livro",
            joinColumns = @JoinColumn(name = "emp_cl_id"),
            inverseJoinColumns = @JoinColumn(name = "liv_cl_id"))
    private Set<Livro> livro;

    @Temporal(TemporalType.DATE)
    @Column(name = "emp_cl_datainicio")
    private java.util.Date dataInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "emp_cl_datadevolucao")
    private java.util.Date dataDevolucao;

    @Enumerated
    @Column(name = "emp_cl_situacao")
    private SituacaoEmprestimo situacao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return Objects.equal(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

}
