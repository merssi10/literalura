package com.alura.literalura.controller;

import com.alura.literalura.model.Libro;
import com.alura.literalura.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private GutendexService gutendexService;

    @GetMapping("/buscar")
    public Optional<Libro> buscarLibroPorTitulo(@RequestParam String titulo) {
        return gutendexService.buscarLibroPorTitulo(titulo);
    }

    @PostMapping("/registrar")
    public String registrarLibro(@RequestBody Libro libro) {
        if (gutendexService.registrarLibro(libro)) {
            return "Libro registrado exitosamente: " + libro.getTitulo();
        } else {
            return "El libro ya está registrado en la base de datos.";
        }
    }

    @GetMapping("/listar")
    public List<Libro> listarLibros() {
        return gutendexService.listarLibros();
    }

    @GetMapping("/autores")
    public List<String> listarAutores() {
        return gutendexService.listarAutores();
    }

    @GetMapping("/autores-vivos")
    public List<String> listarAutoresVivosEnAno(@RequestParam int ano) {
        return gutendexService.listarAutoresVivosEnAno(ano);
    }

    @GetMapping("/idioma")
    public List<Libro> listarLibrosPorIdioma(@RequestParam String idioma) {
        return gutendexService.listarLibrosPorIdioma(idioma);
    }
}
