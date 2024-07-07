package pe.edu.cibertec.ProyectoAPI.service;

import pe.edu.cibertec.ProyectoAPI.model.bd.Libro;

import java.util.List;
import java.util.Optional;

public interface ILibroService {
    List<Libro> obtenerLibros();
    Libro guardarLibro(Libro libro);
    Optional<Libro> buscarLibroPorId(int id);
}
