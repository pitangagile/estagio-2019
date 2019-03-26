package biblioteca.model.modelagem2;

import biblioteca.infraestrutura.IObjectPersistent;
import biblioteca.model.modelagem1.Usuario;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "tb_atividade")
public class Atividade implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoAtividade;

    @Size(min = 30, max = 100)
    @Column(name = "ati_cl_nome")
    private String nome;

    @Size(min = 30, max = 150)
    @Column(name = "ati_cl_descricao")
    private String descricao;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinTable(name = "tb_atividade_has_palavra",
            joinColumns = @JoinColumn(name = "atividade_codigo_atividade"),
            inverseJoinColumns = @JoinColumn(name = "palavra_codigo_palavra"))
    private Set<Palavra> palavra;

    @ManyToMany(mappedBy = "atividade")
    private Set<UsuarioNovo> usuarioNovo;

    @Override
    public Long getId() {
        return null;
    }
}
