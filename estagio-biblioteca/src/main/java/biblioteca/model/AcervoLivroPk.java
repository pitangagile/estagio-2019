package biblioteca.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AcervoLivroPk implements Serializable {

    private Long livroId;
    private Long acervoId;

}
