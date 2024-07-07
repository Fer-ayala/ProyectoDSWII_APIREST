package pe.edu.cibertec.ProyectoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.ProyectoAPI.model.bd.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario,Integer> {
}
