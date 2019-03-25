package biblioteca.model;


import biblioteca.infraestrutura.IObjectPersistent;
import biblioteca.utils.SituacaoEmprestimo;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo implements IObjectPersistent<Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @Temporal(TemporalType.DATE)
  @Column(name = "emp_cl_dataEmprestimo")
  private Date dataEmprestimo;

  @Temporal(TemporalType.DATE)
  @Column(name = "emp_dataDevolucao")
  private Date dataDevolucao;

 @OneToOne
 @JoinColumn(name = "emp_cl_usuario")
  private Usuario usuario;

 @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
 @JoinTable(name = "tb_emprestimo_livro",joinColumns = @JoinColumn(name="emp_cl_id"),inverseJoinColumns = @JoinColumn(name = "liv_cl_id"))
  private Set<Livro> livros;

 @Enumerated()
 @Column(name = "emp_cl_situacao")
 private SituacaoEmprestimo situacao;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Emprestimo that = (Emprestimo) o;
    return Objects.equal(id, that.id) &&
      Objects.equal(dataEmprestimo, that.dataEmprestimo) &&
      Objects.equal(dataDevolucao, that.dataDevolucao) &&
      Objects.equal(usuario, that.usuario) &&
      Objects.equal(livros, that.livros) &&
      situacao == that.situacao;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, dataEmprestimo, dataDevolucao, usuario, livros, situacao);
  }

  @Override
  public Long getId() {
    return null;
  }
}
