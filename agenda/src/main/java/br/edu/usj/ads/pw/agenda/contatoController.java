package br.edu.usj.ads.pw.agenda;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class contatoController {
    
@Autowired
ContatoRepository contatoRepository;

@GetMapping(value = "/")    
public ModelAndView getindex(){
 List<contato> lista = new ArrayList<>();

 lista = contatoRepository.findAll();

 ModelAndView modelAndView = new ModelAndView("index");

 modelAndView.addObject("lista", lista);
 
    return modelAndView;
}


@GetMapping(value = "/cadastro")    
public ModelAndView getcadastro(){
    ModelAndView modelAndView = new ModelAndView("cadastro");
    return modelAndView;
}


@PostMapping(value = "/adicionar")
public ModelAndView postAdicionar(@RequestParam String nome, @RequestParam String tipo, @RequestParam String telefone){

    contato contato = new contato();

    contato.setNome(nome);
    contato.setTipo(tipo);
    contato.setTelefone(telefone);

    contatoRepository.save(contato);

    ModelAndView modelAndView = new ModelAndView("detalhes");

    modelAndView.addObject("contato", contato);


return modelAndView;


}
}