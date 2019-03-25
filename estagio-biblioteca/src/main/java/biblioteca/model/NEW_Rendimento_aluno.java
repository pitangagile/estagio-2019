package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "TB_NEW_Rendimento_aluno")
@Getter @Setter
public class NEW_Rendimento_aluno implements IObjectPersistent<NEW_Rendimento_aluno> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "new_rend_cl_id")
    private Integer id_rendimento;

    @OneToOne
    private NEW_Usuario usuario;

    @OneToOne
    private NEW_Atividade atividade;

    @Column(name = "new_rend_cl_data")
    private Date data;

    @Column(name = "new_rend_cl_hora")
    private Time hora;

    @Column(name = "new_rend_cl_rendimento")
    private double rendimento;





    @Override
    public NEW_Rendimento_aluno getId() {
        return null;
    }
}
