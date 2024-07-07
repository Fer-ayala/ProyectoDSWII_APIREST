package pe.edu.cibertec.ProyectoAPI.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoAPI.model.bd.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService {

    List<Rol> obtenerRoles();
    Rol agregarRol(Rol rol);
    Optional<Rol> buscarRolxId(int id);

}
