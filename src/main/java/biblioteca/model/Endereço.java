package biblioteca.model;


import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="tb_endereco")
public class Endereço implements IObjectPersistent<Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(min = 2)
  @Column(name = "end_cl_logradouro")
  private String logradouro;

  @Size(min = 2)
  @Column(name = "end_cl_bairro")
  private String bairro;

  @Size(min = 2)
  @Column(name = "end_cl_cidade")
  private String cidade;

  @Size(min = 2)
  @Column(name = "end_cl_estado")
  private String estado;

  @Size(min = 8, max=8)
  @Column(name = "end_cl_cep")
  private String cep;

  @OneToOne
  @JoinColumn(name="end_cl_usuario")
  private Usuario usuario;

  @Override
  public Long getId() {
    return null;
  }
}
