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

    @Column(name = "emp_cl_datainicio", nullable = false)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "emp_cl_datadevolucao", nullable = false)
    private Date dataDevolucao;

    @ManyToOne
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "tb_emprestimo_livro",joinColumns = @JoinColumn(name = "emp_cl_id"),inverseJoinColumns = @JoinColumn(name = "livro_cl_id"))
    private Set<Livro> livros;

    @OneToOne
    @JoinColumn(name = "emp_cl_livro")
    private Livro livro;

    @Enumerated
    @Column(name = "emp_cl_situacao")
    private SituacaoEmprestimo situacao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(dataInicio, that.dataInicio) &&
                Objects.equal(dataDevolucao, that.dataDevolucao) &&
                Objects.equal(usuario, that.usuario) &&
                Objects.equal(livros, that.livros) &&
                Objects.equal(livro, that.livro);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, dataInicio, dataDevolucao, usuario, livros, livro);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Set<Livro> livros) {
        this.livros = livros;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public SituacaoEmprestimo getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEmprestimo situacao) {
        this.situacao = situacao;
    }
}
