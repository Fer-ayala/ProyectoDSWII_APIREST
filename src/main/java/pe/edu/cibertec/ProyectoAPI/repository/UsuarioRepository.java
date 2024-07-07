package pe.edu.cibertec.ProyectoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.ProyectoAPI.model.bd.Usuario;


@Repository
public interface UsuarioRepository
    extends JpaRepository<Usuario, Integer> {

    //Select * from usuario where nomusuario = 'lsalvat'
    Usuario findByNomusuario(String nomusuario);
    //Select * from usuario where nombres = 'lsalvat'
    Usuario findByNombres(String nombres);

    Usuario findByEmpleadoNombre(String nombre);

}
