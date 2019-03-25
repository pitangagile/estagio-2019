package biblioteca.model.newModel;


import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class UsuarioAtividadePK implements Serializable {

    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "codigo_Usuario", insertable = false, updatable = false),
            @JoinColumn(name = "codigo_Tipousuario", insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(name = "FK_user_ativi"))
    private Usuario codigoUsuario;

    @ManyToOne
    @JoinColumn(name = "codigo_atividade", referencedColumnName = "id")
    private Atividade codigoAtividade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioAtividadePK that = (UsuarioAtividadePK) o;

        if (codigoUsuario != null ? !codigoUsuario.equals(that.codigoUsuario) : that.codigoUsuario != null)
            return false;
        return codigoAtividade != null ? codigoAtividade.equals(that.codigoAtividade) : that.codigoAtividade == null;
    }

    @Override
    public int hashCode() {
        int result = codigoUsuario != null ? codigoUsuario.hashCode() : 0;
        result = 31 * result + (codigoAtividade != null ? codigoAtividade.hashCode() : 0);
        return result;
    }

    public Usuario getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Usuario codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Atividade getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(Atividade codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }
}
