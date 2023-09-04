package com.itsqmet.Biblioteca.contorladores;


import com.itsqmet.Biblioteca.entidades.Editorial;
import com.itsqmet.Biblioteca.repositorios.AutorRepository;
import com.itsqmet.Biblioteca.repositorios.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
@Controller
public class EditorialController {
    @Autowired
    EditorialRepository editorialRepository;

    //READ
    @GetMapping("/editoriales")
    public String listarEditorial(Model model){
        List<Editorial> editoriales = editorialRepository.findAll();
        model.addAttribute("editoriales",editoriales);

        return "editorial/tablaEditorial";
    }
    //POST CREATE
    @GetMapping("/editorial/form")
    public String formularioeditorial(Model model){
        model.addAttribute("editorial",new Editorial());
        return "editorial/formulario";
    }
    @PostMapping("/editorial/form")
    public String crearEditorial(Editorial editorial){
        editorialRepository.save(editorial);
        return "redirect:/editoriales";

    }
    // UPDATE
    @GetMapping("/editar-editorial/{id}")
    public String actualizarEditorial(@PathVariable int id, Model model){
        Optional<Editorial> editorial = editorialRepository.findById(id);
        model.addAttribute("editorial", editorial);

        return "/editorial/formulario";

    }
    @GetMapping("/eliminar-editorial/{id}")
    public String eliminarEditrorial(@PathVariable int id){
        editorialRepository.deleteById(id);
        return "redirect:/editoriales";
    }

}
