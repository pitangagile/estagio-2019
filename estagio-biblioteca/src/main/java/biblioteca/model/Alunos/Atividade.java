package biblioteca.model.Alunos;

import javax.persistence.*;
import java.util.Set;

//Código da tabela de atividades
@Entity
@Table(name = "atividade")
public class Atividade {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "codigo_atividade")
    private long codigoAtividade;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    //Relacionamento de um para muitos entre uma atividade e os elementos
    // que compõem a tabela de relacionamento entre atividade e palavra
    @OneToMany
    @JoinColumn(name = "atividade_has_palavra")
    private Set<AtividadeHasPalavra> atividadeHasPalavras;

    //Relacionamento de um para muitos entre uma atividade e os elementos
    // que compõem a tabela de relacionamento entre atividade e palavra
    @OneToMany
    @JoinColumn(name = "rendimento_aluno")
    private Set<RendimentoAluno> rendimentoAluno;

    //Relacionamento de um para muitos entre uma atividade e os elementos
    // que compõem a tabela de relacionamento entre atividade e usuário
    @OneToMany
    @JoinColumn(name = "usuario_has_atividade")
    private Set<UsuarioHasAtividade> usuarioHasAtividades;

}
