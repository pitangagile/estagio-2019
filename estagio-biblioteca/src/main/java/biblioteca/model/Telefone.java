package biblioteca.model;


import biblioteca.infraestrutura.IObjectPersistent;
import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tb_telefone")
public class Telefone implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(min = 2, max = 2, message = "O DDD deve ter um tamanho de dois dígitos !")
    @Column(name = "tel_cl_ddd", length = 2, nullable = false)
    private String ddd;


    @Size(max = 9, min = 8)
    @Column(name = "tel_cl_numero", nullable = false)
    private String numero;


    @ManyToOne
    @JoinColumn(name = "tel_cl_usuario")
    private Usuario usuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equal(id, telefone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
