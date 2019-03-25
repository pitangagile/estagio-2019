package biblioteca.model.Alunos;

import javax.persistence.*;
import java.util.Set;

//código para a tabela palavra
@Entity
@Table(name = "palavra")
public class Palavra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "codigo_palavra")
    private long codigoPalavra;

    @Column(name = "palavra")
    private String palavra;

    @Column(name = "figura")
    private String figura;

    @Column(name = "pala_separada")
    private String palaSeparada;

    @Column(name = "letra_ini")
    private String letraIni;

    @Column(name = "letra_final")
    private String letraFinal;

    @Column(name = "maius_ini")
    private String maiusIni;

    @Column(name = "minus_ini")
    private String minusIni;

    //Relacionamento de um para muitos de uma palavra com
    //os elementos da tabela "atividade_has_palavra"
    @OneToMany
    @JoinColumn(name = "atividade_has_palavra")
    private Set<AtividadeHasPalavra> atividadeHasPalavras;

}
