package biblioteca.model.biblioteca;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbacervo")
public class Acervo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ace_cl_nome")
    private String nome;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "acervo")
    private Set<AcervoLivro> acervoLivros;




}
