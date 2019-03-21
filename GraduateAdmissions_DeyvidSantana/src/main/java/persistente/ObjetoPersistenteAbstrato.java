package persistente;

public abstract  class ObjetoPersistenteAbstrato implements IObjetoPersistente{
    public Boolean salvar(){
        return true;
    }

    public Boolean salvar(IObjetoPersistente objetoPersistente){
        return Boolean.TRUE;
    }

    public void buscar(){

    }
}
