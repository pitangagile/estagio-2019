package biblioteca.model.modelagem1;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "comp_cl_livros")
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = Livro.class)
    private Set<Livro> livros;
}
