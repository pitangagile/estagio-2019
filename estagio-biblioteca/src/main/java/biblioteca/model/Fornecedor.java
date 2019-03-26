package biblioteca.model;


import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;

@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "for_cl_compra")
    private Compra compra;

    
    @Override
    public Long getId() {
        return null;
    }
}
