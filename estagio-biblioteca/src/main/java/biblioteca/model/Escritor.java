package biblioteca.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbescritor", schema = "biblioteca")
public class Escritor extends Pessoa{
}
