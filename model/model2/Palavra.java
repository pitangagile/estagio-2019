package biblioteca.model.model2;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "palavra")
public class Palavra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_palavra;

    @ManyToMany(mappedBy = "palavras")
    private List<Atividade> atividades;

    @Column(name = "palavra")
    private String palavra;

    @Column(name = "figura")
    private String figura;

    @Column(name = "pala_separada")
    private String pala_separada;

    @Column(name = "letra_ini")
    private Character letra_ini;

    @Column(name = "letra_final")
    private Character letra_final;

    @Column(name = "maius_ini")
    private Character maius_ini;

    @Column(name = "minus_ini")
    private Character minus_ini;


}
