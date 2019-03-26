package biblioteca.infraestrutura.dao;

import biblioteca.infraestrutura.IObjectPersistent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class AbstractLibraryDao<T extends IObjectPersistent<C>,C> extends AbstractDao<T,C>{

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }


}
