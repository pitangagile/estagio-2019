package biblioteca.model.biblioteca;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_escritor")
@PrimaryKeyJoinColumn()
//@DiscriminatorValue("E")
public class Escritor extends Pessoa {
}
