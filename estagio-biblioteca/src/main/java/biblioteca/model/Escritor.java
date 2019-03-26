package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_escritor")
public class Escritor extends Pessoa {


}
