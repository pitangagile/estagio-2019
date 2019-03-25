package biblioteca.model;


import biblioteca.Utils.SituacaoEmprestimo;
import biblioteca.infraestrutura.IObjectPersistent;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "tb_emprestimo")
public class Emprestimo implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "emp_cl_dtEmprestimo", nullable = false)
    private Date data_emprestimo;

    @Temporal(TemporalType.DATE)
    @Column(name = "emp_cl_dtDevolucao", nullable = false)
    private Date data_devolucao;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Livro livro;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_cl_usuario")
    private Set<Usuario> usuario;

    @Enumerated
    @Column(name = "emp_cl_situacao")
    private SituacaoEmprestimo situacao;

    @OneToMany(mappedBy = "acervo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AcervoLivro> acervo;

    public Emprestimo() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
