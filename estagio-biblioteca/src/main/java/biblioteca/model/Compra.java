package biblioteca.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Login login;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Set<Livro> livros;



}
