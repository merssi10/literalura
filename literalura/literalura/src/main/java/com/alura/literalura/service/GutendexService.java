package com.alura.literalura.service;

import com.alura.literalura.model.Libro;
import com.alura.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GutendexService {

    @Autowired
    private LibroRepository libroRepository;

    private final String GUTENDEX_API_URL = "https://gutendex.com/books?search=";

    public Optional<Libro> buscarLibroPorTitulo(String titulo) {
        RestTemplate restTemplate = new RestTemplate();
        String url = GUTENDEX_API_URL + titulo;
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);

        if (response != null && response.getResults() != null && !response.getResults().isEmpty()) {
            GutendexBook book = response.getResults().get(0);
            String autor = book.getAuthors().isEmpty() ? "Desconocido" : book.getAuthors().get(0).getName();

            Libro libro = new Libro();
            libro.setTitulo(book.getTitle());
            libro.setAutor(autor);
            libro.setIdioma(book.getLanguages().get(0));
            libro.setDescargas(book.getDownload_count());

            return Optional.of(libro);
        }

        return Optional.empty();
    }

    public boolean registrarLibro(Libro libro) {
        if (libroRepository.findByTitulo(libro.getTitulo()).isPresent()) {
            return false;
        }
        libroRepository.save(libro);
        return true;
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public List<String> listarAutores() {
        return libroRepository.findAll()
                .stream()
                .map(Libro::getAutor)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> listarAutoresVivosEnAno(int ano) {
        // Aquí necesito lógica adicional para determinar si los autores estaban vivos en el año dado.
        // Este es un ejemplo simplificado.
        return listarAutores();  // Esto debe ser reemplazado con la lógica correcta.
    }

    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findAllByIdioma(idioma);
    }
}
