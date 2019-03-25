package biblioteca.model;


import biblioteca.infraestrutura.IObjectPersistent;
import com.google.common.base.Objects;
import sun.reflect.generics.reflectiveObjects.LazyReflectiveObjectGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

//@Embeddable //essa classe pode ser utilizada dentro de outra classe sem criar tabela própria
@Entity
@Table(name = "tbtelefone")
public class Telefone implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Length(min = 2, max = 2) //não usar, pois é exclusivo do hibernate...usar @Size
    @Size(min = 2, max = 2, message = "o DDD deve ter tamanho de dois dígitos")
    @Column(name = "tel_cl_ddd", length = 2, nullable = false)
    private String ddd;

    @Size(min = 8, max = 9)
    @Column(name = "tel_cl_numero", nullable = false)
    private String numero;

    @ManyToOne //telefone tem um usuário
    @JoinColumn(name = "tel_cl_usuario")
    private Usuario usuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return id == telefone.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
