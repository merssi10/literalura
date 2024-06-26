package com.alura.literalura;

import com.alura.literalura.model.Libro;
import com.alura.literalura.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    @Autowired
    private GutendexService gutendexService;

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        boolean running = true;
        while (running) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcion) {
                case 1:
                    buscarYRegistrarLibro();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivosEnAno();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 6:
                    running = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Buscar y registrar libro por título");
        System.out.println("2. Listar todos los libros registrados");
        System.out.println("3. Listar todos los autores registrados");
        System.out.println("4. Listar autores vivos en un determinado año");
        System.out.println("5. Listar libros por idioma");
        System.out.println("6. Salir");
    }

    private void buscarYRegistrarLibro() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        Optional<Libro> libroOpt = gutendexService.buscarLibroPorTitulo(titulo);
        if (libroOpt.isPresent()) {
            Libro libro = libroOpt.get();
            if (gutendexService.registrarLibro(libro)) {
                System.out.println("Libro registrado exitosamente: " + libro.getTitulo());
            } else {
                System.out.println("El libro ya está registrado en la base de datos.");
            }
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private void listarLibros() {
        List<Libro> libros = gutendexService.listarLibros();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            libros.forEach(libro -> System.out.println(libro.getTitulo() + " por " + libro.getAutor()));
        }
    }

    private void listarAutores() {
        List<String> autores = gutendexService.listarAutores();
        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarAutoresVivosEnAno() {
        System.out.print("Ingrese el año: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        List<String> autores = gutendexService.listarAutoresVivosEnAno(ano);
        if (autores.isEmpty()) {
            System.out.println("No hay autores vivos en ese año.");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarLibrosPorIdioma() {
        System.out.print("Ingrese el idioma (ES, EN, FR, PT): ");
        String idioma = scanner.nextLine().toUpperCase();
        List<Libro> libros = gutendexService.listarLibrosPorIdioma(idioma);
        if (libros.isEmpty()) {
            System.out.println("No hay libros en ese idioma.");
        } else {
            libros.forEach(libro -> System.out.println(libro.getTitulo() + " por " + libro.getAutor()));
        }
    }
}
