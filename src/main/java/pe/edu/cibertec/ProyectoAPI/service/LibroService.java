package pe.edu.cibertec.ProyectoAPI.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoAPI.model.bd.Libro;
import pe.edu.cibertec.ProyectoAPI.repository.LibroRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LibroService implements ILibroService {

    private LibroRepository libroRepository;

    @Override
    public List<Libro> obtenerLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Optional<Libro> buscarLibroPorId(int id) {
        return libroRepository.findById(id);
    }
}
