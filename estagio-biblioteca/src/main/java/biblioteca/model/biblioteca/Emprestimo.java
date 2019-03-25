package biblioteca.model.biblioteca;


import biblioteca.model.Livro;
import biblioteca.utils.SituacaoEmprestimo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbemprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated()
    @Column(name = "em_cl_situacao")
    private SituacaoEmprestimo situacao;

    @ManyToOne
    @JoinColumn(name = "usu_cl_usuario")
    private Usuario usuario;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Livro.class)
    @JoinTable(
            name = "tb_emprestimo_livro",
            joinColumns = @JoinColumn(
                    name = "id_emprestimo", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "id_livro", referencedColumnName = "id")
    )
    private Set<Livro> livros;



}
