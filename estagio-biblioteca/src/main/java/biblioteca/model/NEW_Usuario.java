package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_NEW_Usuario")
@Getter @Setter
public class NEW_Usuario implements IObjectPersistent<Usuario> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo_usuario;

    
    @EmbeddedId
    public NEW_Tipo_usuarioPK tipo_usuario_codigo;

    @Column(name = "usu_cl_tipo_user")
    private Integer tipo_user;

    @Column(name = "usu_cl_nome")
    private String nome;

    @Column(name = "usu_cl_endereco")
    private String endereco;

    @Column(name = "usu_cl_data_Nasci")
    private String data_nasci;

    @Column(name = "usu_cl_login")
    private String login;

    @Column(name = "usu_cl_senha")
    private String senha;

    /*relação abaixo gera uma tabela NxN com atividades, sendo mapeada aqui na entidade new_usuario
    * utilizando eager aqui, pois é importante ter as atividades carregadas no usuário, para evitar
    * ter que abrir ou forçar a persistência de uma janela de conexão com o banco, usando DETATCH
    * para poder não sofrer alterações em todos os eventos, apenas nas remoções  da persistência*/

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(name = "TB_NEW_usuario_has_atividades", joinColumns = {@JoinColumn(name = "usr_cl_id"),
    @JoinColumn(name = "tp_cl_usuario_codigo")}, inverseJoinColumns = @JoinColumn(name = "atv_cl_id"))
    private List<NEW_Atividade> new_atividades;


    public NEW_Usuario() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NEW_Usuario usuario = (NEW_Usuario) o;

        return codigo_usuario.equals(usuario.codigo_usuario);
    }

    @Override
    public int hashCode() {
        return codigo_usuario.hashCode();
    }

    @Override
    public Usuario getId() {
        return null;
    }
}
