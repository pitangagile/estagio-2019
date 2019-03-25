package biblioteca.model;


import biblioteca.infraestrutura.IObjectPersistent;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_NEW_Atividade")
@Getter @Setter
public class NEW_Atividade implements IObjectPersistent<NEW_Atividade> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "atv_cl_id")
    private Integer codigo_atividade;

    @Column(name = "atv_cl_nome")
    private String nome;

    @Column(name = "atv_cl_descricao")
    private String descricao;

    /*relação abaixo gera uma tabela NxN com new_palavra, sendo mapeada aqui na entidade new_atividade
     * utilizando eager aqui, pois é importante ter as atividades carregadas no usuário, para evitar
     * ter que abrir ou forçar a persistência de uma janela de conexão com o banco, usando DETATCH
     * para poder não sofrer alterações em todos os eventos, apenas nas remoções  da persistência*/
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(name = "TB_NEW_atividade_has_palavras", joinColumns = @JoinColumn(name = "atv_cl_id"),
    inverseJoinColumns = @JoinColumn(name = "plvr_cl_id"))
    private Set<NEW_Palavra> new_palavras;

    //NxN com mapeaento realizada em new_usuario
    @ManyToMany(mappedBy = "new_atividades", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<NEW_Usuario> new_usuarios;

    @Override
    public NEW_Atividade getId() {
        return null;
    }
}
