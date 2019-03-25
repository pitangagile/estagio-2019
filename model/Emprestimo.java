package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;
import biblioteca.utils.SituacaoEmprestimo;

import javax.persistence.*;
import javax.validation.constraints.Size;;
import java.util.Date;
import java.util.Set;

@Table
@Entity(name = "tbemprestimo")
public class Emprestimo implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinColumn(name = "emp_cl_usuario")
    private Set<Usuario> usuario;

    @ManyToMany
    @JoinColumn(name = "emp_cl_livro")
    private Set<Livro> livro;

    @Column(name = "emp_cl_dataInicio", nullable = false)
    private Date dataInicio;

    @Column(name = "emp_cl_dataFinal", nullable = false)
    private Date dataFinal;

    @Enumerated
    @Column(name = "emp_cl_situacao", nullable = false)
    private SituacaoEmprestimo situacaoEmprestimo;

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }

    public Set<Livro> getLivro() {
        return livro;
    }

    public void setLivro(Set<Livro> livro) {
        this.livro = livro;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public SituacaoEmprestimo getSituacaoEmprestimo() {
        return situacaoEmprestimo;
    }

    public void setSituacaoEmprestimo(SituacaoEmprestimo situacaoEmprestimo) {
        this.situacaoEmprestimo = situacaoEmprestimo;
    }
}
