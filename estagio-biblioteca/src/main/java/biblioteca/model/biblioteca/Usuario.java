package biblioteca.model.biblioteca;




import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
//@DiscriminatorValue("U")
public class Usuario extends Pessoa {


    @Size(min = 11, max = 11)
    @Column(name = "usu_cl_cpf", length = 11)
    private String cpf;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Endereco endereco;



    public Usuario() {
    }



}
