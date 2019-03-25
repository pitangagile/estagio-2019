package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("E")
//@PrimaryKeyJoinColumn(name = "id")
@Table(name = "tb_escritor")
public class Escritor extends Pessoa {

}
