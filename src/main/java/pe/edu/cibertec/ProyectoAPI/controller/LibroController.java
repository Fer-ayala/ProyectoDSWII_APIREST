package pe.edu.cibertec.ProyectoAPI.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.ProyectoAPI.model.bd.Libro;
import pe.edu.cibertec.ProyectoAPI.service.ILibroService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/libros")
public class LibroController {

    private ILibroService iLibroService;

    @GetMapping("/listar")
    public List<Libro> listarLibros(){
        return iLibroService.obtenerLibros();
    }

}
