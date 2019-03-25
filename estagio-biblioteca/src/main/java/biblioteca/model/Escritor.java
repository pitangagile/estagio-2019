package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//@Entity //no caso de criar uma coluna grande representando a classe abstrata contendo todos os filhos concretos juntos
//@DiscriminatorValue("E")

//@Entity //abordagem de fazer tabelas para classes abstratas e classes concretas
//@PrimaryKeyJoinColumn(name = "id")

@Entity //abordagem de implementar apenas as tabelas das classes concretas
@Table(name = "tbescritor")
public class Escritor extends Pessoa {

}
