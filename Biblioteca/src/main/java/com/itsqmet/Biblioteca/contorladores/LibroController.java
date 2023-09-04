package com.itsqmet.Biblioteca.contorladores;


import com.itsqmet.Biblioteca.entidades.Autor;
import com.itsqmet.Biblioteca.entidades.Editorial;
import com.itsqmet.Biblioteca.entidades.Libro;
import com.itsqmet.Biblioteca.repositorios.AutorRepository;
import com.itsqmet.Biblioteca.repositorios.EditorialRepository;
import com.itsqmet.Biblioteca.repositorios.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class LibroController {

    @Autowired
    LibroRepository libroRepository;

    @Autowired
    AutorRepository autorRepository;
    @Autowired
    EditorialRepository editorialRepository;
    //READ
    @GetMapping("/libros")
    public String listarlibro(Model model ){
        List<Libro> libros=libroRepository.findAll();
        model.addAttribute("libros", libros);

        return"libro/tablaLibro";
    }

    //CREATE
    @GetMapping("/libro/form")
    public String formulariolibro(Model model){
        model.addAttribute("libro", new Libro());

        List<Autor> autores = autorRepository.findAll();
        model.addAttribute("autores", autores);
        List<Editorial> editoriales = editorialRepository.findAll();
        model.addAttribute("editoriales", editoriales);

        return "libro/formulario";
    }

    @PostMapping("/libro/form")
    public String crearLibro(Libro libro){
        libroRepository.save(libro);
        return "redirect:/libros";
    }

    // UPDATE
    @GetMapping("/editar-libro/{id}")
    public String actualizarlibro(@PathVariable int id, Model model){
        Optional<Libro> libro = libroRepository.findById(id);
        model.addAttribute("libro", libro);
        List<Autor> autores = autorRepository.findAll();
        model.addAttribute("autores", autores);
        List<Editorial> editoriales = editorialRepository.findAll();
        model.addAttribute("editoriales", editoriales);

        return "/libro/formulario";

    }
    @GetMapping("/eliminar-libro/{id}")
    public String eliminarlibro(@PathVariable int id){
        libroRepository.deleteById(id);
        return "redirect:/libros";
    }
}
