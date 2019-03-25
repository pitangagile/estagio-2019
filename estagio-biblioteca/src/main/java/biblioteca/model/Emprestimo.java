package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;
import biblioteca.utils.SituacaoEmprestimo;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Table
@Entity(name = "tbemprestimo")
public class Emprestimo implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "emp_cl_usuario")
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tb_emprestimo_livro",joinColumns = @JoinColumn(name = "emp_cl_id"),
            inverseJoinColumns = @JoinColumn(name = "liv_cl_id"))
    private Set<Livro> livros;

    @Temporal(TemporalType.DATE)
    @Column(name = "emp_cl_datainicio")
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "emp_cl_datadevolucao")
    private Date dataDevolucao;

    @Enumerated
    @Column(name = "emp_cl_situacao")
    private SituacaoEmprestimo situacao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return id == that.id;
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

    public Set<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Set<Livro> livros) {
        this.livros = livros;
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

    public SituacaoEmprestimo getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEmprestimo situacao) {
        this.situacao = situacao;
    }
}
