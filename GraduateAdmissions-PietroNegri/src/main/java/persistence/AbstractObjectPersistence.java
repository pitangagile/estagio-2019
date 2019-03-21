package persistence;

public abstract class AbstractObjectPersistence implements IObjetoPersistente {

    public boolean save() {
        return true;
    }

    public boolean save(IObjetoPersistente objetoPersistente) {
        return true;
    }

}
