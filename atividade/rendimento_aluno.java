package biblioteca.model.atividade;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "rendimento_aluno")
public class rendimento_aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_rendimento;

    @EmbeddedId
    private rendimento_alunoPK rendimento_alunoPK;

    @Size
    @Column(name = "codigo_aluno")
    private Long codigo_aluno;

    @Size
    @Column(name = "codigo_atividade")
    private Long codigo_atividade;

    @Size
    @Column(name = "data_2")
    private Long data_2;

    @Size
    @Column(name = "hora")
    private Long hora;

    @Size
    @Column(name = "rendimento")
    private Long rendimento;


}
