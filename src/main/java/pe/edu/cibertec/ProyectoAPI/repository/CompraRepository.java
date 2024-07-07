package pe.edu.cibertec.ProyectoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.ProyectoAPI.model.bd.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Integer> {
}
