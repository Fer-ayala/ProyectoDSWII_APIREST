package pe.edu.cibertec.ProyectoAPI.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.ProyectoAPI.model.bd.Inventario;
import pe.edu.cibertec.ProyectoAPI.repository.InventarioRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class InventarioService implements IInventarioService {

    private InventarioRepository inventarioRepository;

    @Override
    public List<Inventario> obtenerInventarios() {
        return inventarioRepository.findAll();
    }

    @Override
    public Inventario guardarInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public Optional<Inventario> buscarInventarioPorId(int id) {
        return inventarioRepository.findById(id);
    }
}
