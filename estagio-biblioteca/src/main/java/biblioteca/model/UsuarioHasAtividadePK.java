package biblioteca.model.Alunos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class UsuarioHasAtividadePK implements Serializable {

  
	@Column(name = "atividade_codigo_atividade",nullable = false)
    private long codigoAtividade;
	
    @Column(name = "usuario_codigo_usuario",nullable = false)
    private long codigoUsuario;

    @Column(name = "usuario_tipo_usuario_codigo",nullable = false)
    private long codigoTipoUsuario;

    public long getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(long codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }
    
    public long getCodigoTipoUsuario() {
        return codigoTipoUsuario;
    }

    public void setCodigoTipoUsuario(long codigoTipoUsuario) {
        this.codigoTipoUsuario = codigoTipoUsuario;
    }
   
    public long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioHasAtividadePK that = (UsuarioHasAtividadePK) o;

        if (codigoUsuario != that.codigoUsuario) return false;
        if (codigoTipoUsuario != that.codigoTipoUsuario) return false;
        return codigoAtividade == that.codigoAtividade;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigoTipoUsuario, codigoUsuario, codigoAtividade);
}
}
