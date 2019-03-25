package biblioteca.model.newModel;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "atividade")
public class Atividade implements IObjectPersistent<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "id.codigoAtividade")
    private Set<Usuario_has_Atividade> usuarioAtividade;

    @OneToMany(mappedBy = "codigo.codigoAtividade") //explicitando um mappedBy, nenhuma tabela é criada a mais
    private Set<Atividade_has_Palavra> atividadepalavra;

    @OneToMany(mappedBy = "codigoAtividade")
    private Set<RendimentoAluno> rendimentoAluno;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atividade atividade = (Atividade) o;

        return id != null ? id.equals(atividade.id) : atividade.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public Long getId() {
        return null;
    }
}
