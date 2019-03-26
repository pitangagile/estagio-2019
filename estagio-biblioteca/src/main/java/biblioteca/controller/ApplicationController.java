package biblioteca.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "/", description = "Legal !")
public class ApplicationController {

    @GetMapping(value = "/")
    public void inicio() {

    }

    @GetMapping(value = "/error")
    public  String erro() {
        return "Ops ! algo errado não está certo :(";

    }



}
