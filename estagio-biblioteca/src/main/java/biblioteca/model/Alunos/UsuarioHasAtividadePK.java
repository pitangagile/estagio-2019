package biblioteca.model.Alunos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

//classe embarcável utilizada para geração de chave composta para a tabela "usuario_has_atividade"
@Embeddable
public class UsuarioHasAtividadePK implements Serializable {

    //coluna para mapeamento de usuario
    @Column(name = "usuario_codigo_usuario",nullable = false)
    private long codigoUsuario;

    //coluna para mapeamento de tipo de usuario
    @Column(name = "usuario_tipo_usuario_codigo",nullable = false)
    private long codigoTipoUsuario;

    //coluna para mapeamento de atividade
    @Column(name = "atividade_codigo_atividade",nullable = false)
    private long codigoAtividade;

    public long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public long getCodigoTipoUsuario() {
        return codigoTipoUsuario;
    }

    public void setCodigoTipoUsuario(long codigoTipoUsuario) {
        this.codigoTipoUsuario = codigoTipoUsuario;
    }

    public long getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(long codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
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
        int result = (int) (codigoUsuario ^ (codigoUsuario >>> 32));
        result = 31 * result + (int) (codigoTipoUsuario ^ (codigoTipoUsuario >>> 32));
        result = 31 * result + (int) (codigoAtividade ^ (codigoAtividade >>> 32));
        return result;
    }
}
