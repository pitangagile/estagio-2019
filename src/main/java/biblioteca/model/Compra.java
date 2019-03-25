package biblioteca.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_compra")
public class Compra {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;




}
