package biblioteca.model.atividade;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "atividade")
public class atividade implements Serializable {

    @EmbeddedId
    private atividadePK codigo_atividade;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;


}
