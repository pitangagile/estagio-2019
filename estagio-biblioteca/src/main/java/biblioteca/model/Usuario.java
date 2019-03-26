package biblioteca.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends Pessoa {


    @Size(max = 11, min = 11)
    @Column(name = "usu_cl_cpf", length = 11)
    private String cpf;

    @Override
    public Long getId() {
        return null;
    }





    /*nome




    logradouro
    bairro
    cidade
    estado
    cep
    complemento
    */
}
