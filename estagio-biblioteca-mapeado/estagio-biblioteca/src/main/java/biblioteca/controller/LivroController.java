package biblioteca.controller;

import biblioteca.dao.LivroDAO;
import biblioteca.infraestrutura.controller.AbstractController;
import biblioteca.infraestrutura.dao.AbstractDao;
import biblioteca.model.modelagem1.Livro;
import biblioteca.model.modelagem1.LivroDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@RestController
@Api(value = "Livro", description = "Performa operações sobre livros da nossa biblioteca")
public class LivroController extends AbstractController<Livro, Long> implements ILivroController {


    @Autowired(required = true)
    private LivroDAO livroDAO;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String hello() {

        Json json = new Json("hello");
        return json.value();
    }

    @RequestMapping(value = "/livros", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Livro> getAllBooks() {

        return this.findAll();
    }

    @Transactional
    @PostMapping(value = "/livro/criar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Boolean createBooks(@RequestBody LivroDTO livroRequest) {
        Livro livro = new Livro();
        livro.setSinopse(livroRequest.getSinopse());
        livro.setTitulo(livroRequest.titulo);
        livro.setAnoLancamento(livroRequest.anoLancamento);

        try {
            this.insert(livro);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return Boolean.FALSE;


    }

    @Override
    public AbstractDao<Livro, Long> getDao() {
        return livroDAO;
    }

    @Override
    public void setDao(AbstractDao<Livro, Long> dao) {
        super.setDao(livroDAO);
    }
}
