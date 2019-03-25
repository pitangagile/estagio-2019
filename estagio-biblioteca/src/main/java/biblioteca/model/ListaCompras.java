package biblioteca.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tblistacompras", schema = "biblioteca")
public class ListaCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}
