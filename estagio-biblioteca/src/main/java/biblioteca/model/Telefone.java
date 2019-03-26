package biblioteca.model;


import biblioteca.infraestrutura.IObjectPersistent;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "tb_telefone")
public class Telefone implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max =2, message = "O DDD deve ter o tamanho de dois  dígitos")
    @Column(name = "tel_cl_ddd")
    private String ddd;

    @Size(min = 8, max = 9)
    @Column(name = "tel_cl_numero")
    private String numero;

    @ManyToOne
    @JoinColumn(name = "tel_cl_usuario")
    private Usuario usuario;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(ddd, telefone.ddd) &&
                Objects.equals(numero, telefone.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddd, numero);
    }

    @Override
    public Long getId() {
        return null;
    }
}
