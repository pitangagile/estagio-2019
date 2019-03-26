package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;
import biblioteca.utils.SituacaoEmprestimo;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;


    @ManyToMany(fetch = FetchType.LAZY, cascade =
            {CascadeType.PERSIST, CascadeType.MERGE
            })
    @JoinTable(name = "tb_emprestimo_livro",
            joinColumns = @JoinColumn(name = "emp_cl_id"),
            inverseJoinColumns = @JoinColumn(name = "liv_cl_id")

    )
    private Set<Livro> livros;

    @Temporal(TemporalType.DATE)
    @Column(name = "emp_cl_dataemprestimo")
    private Date dataEmprestimo;

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
        return Objects.equal(id, that.id) &&
                Objects.equal(usuario, that.usuario) &&
                Objects.equal(livros, that.livros) &&
                Objects.equal(dataEmprestimo, that.dataEmprestimo) &&
                Objects.equal(dataDevolucao, that.dataDevolucao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, usuario, livros, dataEmprestimo, dataDevolucao);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
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
