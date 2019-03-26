package biblioteca.model.Atividades;

import javax.persistence.*;

@Entity
@Table(name = "rendimento_aluno")
public class RendimentoAluno {

    @Id
    @Column(name="id_rendimento", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "atividade_codigo_atividade")
    private Usuario codigoAtividade;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumns(value = {
            @JoinColumn(name = "usuario_tipo_usuario_codigo", insertable = false, updatable = false)
            @JoinColumn(name =  "usuario_codigo_usuario", insertable = false, updatable = false),
    },foreignKey = @ForeignKey(name = "FK_Rendimento_Usuario"))
    private Usuario usuario;



}
