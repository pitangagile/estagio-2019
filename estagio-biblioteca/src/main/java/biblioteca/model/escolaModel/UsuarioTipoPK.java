package biblioteca.model.escolaModel;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioTipoPK implements Serializable {

    // Essa classe é a que faz a chave composta que é setada em usuario.

    // Codigo usuario é a primeira chave da tabela usuario
    @Column(name = "codigo_usuario",nullable = false)
    private Integer codigo_usuario;

    //Tipo usuario é a fk que compõe a pk de usuario.
    @ManyToOne
    @JoinColumn(name = "codigo_tipousuario", referencedColumnName = "codigo_tipoUsuario")
    private TipoUsuario codigo_tipoUsuario;


    // Equals and hashcodes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioTipoPK that = (UsuarioTipoPK) o;
        return Objects.equals(codigo_usuario, that.codigo_usuario) &&
                Objects.equals(codigo_tipoUsuario, that.codigo_tipoUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_usuario, codigo_tipoUsuario);
    }

    // Getters and setters

    public Integer getcodigo_usuario() {
        return codigo_usuario;
    }

    public void setcodigo_usuario(Integer codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public TipoUsuario getodigo_tipoUsuario() {
        return codigo_tipoUsuario;
    }

    public void setcodigo_tipoUsuario(TipoUsuario codigo_tipoUsuario) {
        this.codigo_tipoUsuario = codigo_tipoUsuario;
    }
}
