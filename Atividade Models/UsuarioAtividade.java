package biblioteca.model.Atividades;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario_has_atividade")
public class UsuarioAtividade {

    @EmbeddedId
    private UsuarioAtividadePK usuarioAtividadePk;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_tipo_usuario_codigo", insertable = false, updatable = false)
    private Usuario tipoUsuarioCodigo;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_codigo_usuario", insertable = false, updatable = false)
    private Usuario usuarioCodigo;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("atividade_codigo_atividade")
    @JoinColumn(name = "atividade_codigo_atividade", insertable = false, updatable = false)
    private Atividade AtividadecodigoAtividade;

    @Column(name = "codigo_aluno")
    private int codigoAluno;

    @Column(name = "codigo_atividade")
    private int codigoAtividade;

    @Size(min = 4,max = 15)
    @Column(name = "data_2")
    private int data2;

    @Column(name = "hora")
    private int hora;

    @Column(name = "rendimento")
    private int rendimento;



}
