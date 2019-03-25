package biblioteca.model.Alunos;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

//Tabela para mapeamento de tipos de usuario
@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "descricao")
    private String descricao;

    //Relacionamento de um para muitos entre um tipo de usuario e os usuarios
    @OneToMany
    @JoinColumn(name = "codigo_usuario")
    private Set<Usuario> usuarios;

}
