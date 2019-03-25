package biblioteca.model.escola;


import biblioteca.infraestrutura.IObjectPersistent;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "esc_tb_atividade")
public class Atividade implements IObjectPersistent<Integer> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_atividade;


    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "atividade")
    private Set<UsuarioAtividade> usuarioAtividade;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Palavra.class)
    @JoinTable(
            name = "tb_atividade_has_palavra",
            joinColumns = @JoinColumn(
                    name = "atividade_codigo_atividade2", referencedColumnName = "codigo_atividade"),
            inverseJoinColumns = @JoinColumn(
                    name = "palavra_codigo_palavra", referencedColumnName = "codigo_palavra")
    )
    private Set<Palavra> palavras;


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
