import biblioteca.infraestrutura.application.AppConfig;
import biblioteca.model.Livro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {AppConfig.class},
        loader = AnnotationConfigContextLoader.class)
public class SuperTest {


    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Before
    public void before() {
        this.session =sessionFactory.openSession();
    }


    // Inserir 3 livros
    // Inserir 6 emprestimo
    // Criar um acervo
    // inserir 2 escritores
    @Test
    public void inserirtTodos() {
        Livro livro = new Livro();
        livro.setAnoLancamento("2015");
        livro.setTitulo("A menina que roubava livros");
        livro.setSinopse("A menina roubava livros na segunda guerra");
        this.session.persist(livro);
    }

    @Ignore
    public void obterTodosOsLivroDeUmEscritor() {

    }


    @Ignore
    public  void obterTodosLivrosDeUmAcervo() {

    }

    @Ignore
    public void verificarSeUsuarioTemEmprestimo() {

    }

    @Ignore
    public void verificarSeAlgumaPessoaEEscritor() {

    }

    @After
    public void after() {
        session.close();
        sessionFactory.close();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}