package biblioteca.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_login")
public class Login{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cl_login")
    private String login;

    @Column(name = "cl_senha")
    private String senha;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Pessoa pessoa;






}
