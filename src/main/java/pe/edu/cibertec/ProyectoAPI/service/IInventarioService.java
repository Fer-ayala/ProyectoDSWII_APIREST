package pe.edu.cibertec.ProyectoAPI.service;
import pe.edu.cibertec.ProyectoAPI.model.bd.Inventario;

import java.util.List;
import java.util.Optional;
public interface IInventarioService {
    List<Inventario> obtenerInventarios();
    Inventario guardarInventario(Inventario inventario);
    Optional<Inventario> buscarInventarioPorId(int id);
}
