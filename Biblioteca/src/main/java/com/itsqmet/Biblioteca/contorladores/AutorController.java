package com.itsqmet.Biblioteca.contorladores;

import com.itsqmet.Biblioteca.entidades.Autor;
import com.itsqmet.Biblioteca.repositorios.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    //READ
    @GetMapping("/autores")
    public String listarAutor(Model model){
        List<Autor> autores = autorRepository.findAll();
        model.addAttribute("autores",autores);

        return "autor/tablaAutor";
    }
    //POST CREATE
    @GetMapping("/autor/form")
    public String formularioAutor(Model model){
        model.addAttribute("autor",new Autor());
        return "/autor/formulario";
    }
    @PostMapping("/autor/form")
    public String crearAutor(Autor autor){
        autorRepository.save(autor);
        return "redirect:/autores";

    }
    // UPDATE
    @GetMapping("/editar/{id}")
    public String actualizar(@PathVariable int id, Model model){
        Optional<Autor> autor = autorRepository.findById(id);
        model.addAttribute("autor", autor);

        return "/autor/formulario";

    }
    @GetMapping("/eliminar/{id}")
    public String eliminarAutor(@PathVariable int id){
        autorRepository.deleteById(id);
        return "redirect:/autores";
    }
}
