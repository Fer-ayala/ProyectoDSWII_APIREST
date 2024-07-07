package pe.edu.cibertec.ProyectoAPI.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoAPI.model.bd.Rol;
import pe.edu.cibertec.ProyectoAPI.repository.RolRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RolService implements IRolService {

    private RolRepository rolRepository;

    @Override
    public List<Rol> obtenerRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol agregarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Optional<Rol> buscarRolxId(int id) {
        return rolRepository.findById(id);
    }
}
