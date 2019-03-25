package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "tb_acervo")
public class Acervo implements IObjectPersistent<Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ace_cl_nome")
  private String nome;

  @OneToMany(mappedBy = "acervo",cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<AcervoLivro> acervoLivro;


  @Override
  public Long getId() {
    return this.id;
  }
}
