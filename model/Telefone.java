package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbtelefone")
public class Telefone implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 3)
    @Column(name = "tel_cl_ddd", length = 2, nullable = false)
    private String ddd;

    @Size(min = 8, max = 9)
    @Column(name = "tel_cl_numero")
    private String numero;

    @ManyToOne
    @JoinColumn(name = "tel_cl_usuario")
    private Usuario usuario;

    @Override
    public Long getId() {
        return this.id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
