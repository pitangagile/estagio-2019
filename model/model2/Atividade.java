package biblioteca.model.model2;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "atividade")
public class Atividade implements IObjectPersistent<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_atividade;

    @OneToMany
    @JoinColumn(name = "rendimento_aluno")
    private List<RendimentoAluno> rendimentoAluno;

    @OneToMany
    @JoinColumn(name = "usuario_has_atividade")
    private List<UsuarioHasAtividade> usuarioHasAtividades;

    @ManyToMany
    @JoinTable(name="atividade_has_palavra", joinColumns=
            {@JoinColumn(name="atividade_codigo_atividade")}, inverseJoinColumns=
            {@JoinColumn(name="palavra_codigo_palavra")})
    private List<Palavra> palavras;

    @Size(min = 3, max = 30)
    @Column(name = "nome",nullable = false)
    private String nome;

    @Size(min = 3, max = 50)
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Override
    public Integer getId() {
        return this.codigo_atividade;
    }
}
