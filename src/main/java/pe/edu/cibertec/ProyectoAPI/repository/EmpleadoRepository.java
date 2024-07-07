package pe.edu.cibertec.ProyectoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.ProyectoAPI.model.bd.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {
    Empleado findByUsuarioNomusuario(String nomusuario);
}
