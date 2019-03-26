package biblioteca.model.modelagem1;

import biblioteca.infraestrutura.IObjectPersistent;
import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_telefone")
public class Telefone implements IObjectPersistent<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min=2,max=2,message = "O DDD deve ter um tamanho de dois dígitos")
    @Column(name = "tel_cl_ddd", length = 2, nullable = false)
    private String ddd;

    @Size(min = 8, max = 9)
    @Column(name = "tel_cl_numero", nullable = false)
    private String numero;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Pessoa pessoa;

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public Long getId() {
        return null;
    }

}
