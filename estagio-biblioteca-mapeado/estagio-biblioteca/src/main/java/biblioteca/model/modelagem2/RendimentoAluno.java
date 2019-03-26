package biblioteca.model.modelagem2;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;

@Entity
@Table(name = "tb_rendimentoaluno")
public class RendimentoAluno implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRendimento;


    private Integer atividadeCodigoAtividade;

    private Integer usuarioTipoUsuarioCodigo;

    private Integer usuarioCodigoUsuario;

    @Column(name = "rendaluno_cl_codigoaluno")
    private Integer codigoAluno;

    @Column(name = "rendaluno_cl_codigoatividade")
    private Integer codigoAtividade;

    @Column(name = "rendaluno_cl_data2")
    private Integer data2;

    @Column(name = "rendaluno_cl_hora")
    private Integer hora;

    @Column(name = "rendaluno_cl_rendimento")
    private Integer rendimento;

    @Override
    public Long getId() {
        return null;
    }
}
