package biblioteca.model.modelagem1;

import biblioteca.infraestrutura.IObjectPersistent;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_escritor")
public class Escritor extends Pessoa implements IObjectPersistent<Long> {

    @ManyToMany
    @JoinTable(name = "tb_escritor_livros",
            joinColumns = @JoinColumn(name = "esc_cl_id"),
            inverseJoinColumns = {@JoinColumn(name = "liv_cl_id")})
    private Set<Livro> livros;

}