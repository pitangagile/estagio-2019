package persistente;

public interface IObjetoPersistente{

    public Boolean salvar();

    public Boolean salvar(IObjetoPersistente objetoPersistente);

    public IObjetoPersistente buscar();
}
