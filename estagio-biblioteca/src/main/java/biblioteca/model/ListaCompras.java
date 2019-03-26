package biblioteca.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_listaCompras", schema = "biblioteca")

public class ListaCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
