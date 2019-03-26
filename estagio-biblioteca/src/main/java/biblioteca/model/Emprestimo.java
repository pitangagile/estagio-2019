package biblioteca.model;


import biblioteca.infraestrutura.IObjectPersistent;
import biblioteca.utils.SituacaoEprestimo;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany( fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tb_emprestimo_livro", joinColumns = @JoinColumn(name = "emp_cl_id"), inverseJoinColumns = @JoinColumn (name = "liv_cl_id"))
    private Set<Livro> livros;

    @OneToOne
    private Usuario usuario;

    @Enumerated
    @Column(name = "emp_cl_situacao")
    private SituacaoEprestimo situacao;

    @Size(min = 8, max = 9)
    @Column(name = "emp_cl_datainicio")
    private Date dataInicio;

    @Size(min = 8, max = 9)
    @Column(name = "emp_cl_devolucao")
    private Date dataDevolucao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public SituacaoEprestimo getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEprestimo situacao) {
        this.situacao = situacao;
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

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(livros, that.livros) &&
                Objects.equals(usuario, that.usuario) &&
                situacao == that.situacao &&
                Objects.equals(dataInicio, that.dataInicio) &&
                Objects.equals(dataDevolucao, that.dataDevolucao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, livros, usuario, situacao, dataInicio, dataDevolucao);
    }
}
