package pe.edu.cibertec.ProyectoAPI.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoAPI.exception.ResourceNotFoundException;
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

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/registrar")
    public ResponseEntity<Libro> registrarLibro(@RequestBody Libro libro){
        return new ResponseEntity<>(iLibroService.guardarLibro(libro), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Integer id,@RequestBody Libro libro){
        Libro newLibro = iLibroService.buscarLibroPorId(id).orElseThrow(()->new ResourceNotFoundException("la" +
                "categoria con id " + id + " no existe"));
        newLibro.setAutor(libro.getAutor());
        newLibro.setEditorial(libro.getEditorial());
        newLibro.setGenero(libro.getGenero());
        newLibro.setTitulo(libro.getTitulo());
        newLibro.setDetallescompra(libro.getDetallescompra());
        newLibro.setFechaPublicacion(libro.getFechaPublicacion());
        return new ResponseEntity<>(
                iLibroService.guardarLibro(newLibro),
                HttpStatus.CREATED);
    }



}
