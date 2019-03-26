package biblioteca.model.Alunos;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoAtividade;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    
    @OneToMany
    @JoinColumn(name = "usuario_has_atividade")
    private Set<UsuarioHasAtividade> usuarioAtividades;
    
    @OneToMany
    @JoinColumn(name = "rendimento_aluno")
    private Set<RendimentoAluno> rendimentoAluno;

    @OneToMany
    @JoinColumn(name = "atividade_has_palavra")
    private Set<AtividadeHasPalavra> atividadePalavras;
     
    @Override
    public Integer getId() {
        return this.codigo_atividade;
    }


    public void setCodigo_atividade(Integer codigo_atividade) {
        this.codigo_atividade = codigo_atividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}

