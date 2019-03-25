package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbacervo")
public class Acervo implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ace_cl_nome")
    private String nome;

    @OneToMany(mappedBy = "acervo", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Acervo_Livro> acervo_livro;

    @Override
    public Long getId() {
        return id;
    }
}
