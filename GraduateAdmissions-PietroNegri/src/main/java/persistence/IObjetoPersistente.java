package persistence;

public interface IObjetoPersistente {

    public boolean save();

    public boolean save(IObjetoPersistente objetoPersistente);

    public IObjetoPersistente buscar();





}
