package biblioteca.model.escolaModel;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_atividade")
public class Atividade implements IObjectPersistent<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_atividade;

    @Column(name = "ati_cl_nome")
    private String nome;

    @Column(name = "ati_cl_descricao")
    private String descricao;

    @ManyToMany(mappedBy = "atividades") //uma atividade poderá ter várias palavras e uma palavra pode estar em varias atividades
    private Set<Palavra> palavras;

    @ManyToMany(mappedBy = "atividades") //um usuario pode ter varias atividades e uma atividade pode ter varios usuarios
    private Set<Usuario> usuarios;

    //Uma atividade pode ter varios rendimentos de alunos associadas a ela.
    @OneToMany(mappedBy = "atividade", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RendimentoAluno> rendimentoAlunos;

    // Equals and hashcodes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade atividade = (Atividade) o;
        return Objects.equals(codigo_atividade, atividade.codigo_atividade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_atividade);
    }

    // Getters and Setters
    public Integer getCodigo_atividade() {
        return codigo_atividade;
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

    public Set<Palavra> getPalavras() {
        return palavras;
    }

    public void setPalavras(Set<Palavra> palavras) {
        this.palavras = palavras;
    }

    @Override
    public Integer getId() {
        return codigo_atividade;
    }
}
