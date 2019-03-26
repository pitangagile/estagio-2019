package biblioteca.model.Atividades;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Table(name = "atividade")
public class Atividade {
    @Id
    @Column(name="codigo_atividade", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100, min = 2)
    @Column(name = "ativ_cl_nome",nullable = false)
    private String nome;

    @Size(max = 100, min = 2)
    @Column(name = "ativ_cl_descricao",nullable = false)
    private String descricao;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Palavra.class)
    @JoinTable(
            name = "atividade_has_palavra",
            joinColumns = @JoinColumn(
                    name = "atividade_codigo_atividade", referencedColumnName = "codigo_atividade"),
            inverseJoinColumns = @JoinColumn(
                    name = "palavra_codigo_palavra", referencedColumnName = "codigo_palavra")
    )
    private Set<Palavra> palavras;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atividade atividade = (Atividade) o;

        if (id != null ? !id.equals(atividade.id) : atividade.id != null) return false;
        if (nome != null ? !nome.equals(atividade.nome) : atividade.nome != null) return false;
        return descricao != null ? descricao.equals(atividade.descricao) : atividade.descricao == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
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
