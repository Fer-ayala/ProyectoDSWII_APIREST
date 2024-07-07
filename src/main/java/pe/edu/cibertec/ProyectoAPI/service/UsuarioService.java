package pe.edu.cibertec.ProyectoAPI.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoAPI.model.bd.Usuario;
import pe.edu.cibertec.ProyectoAPI.repository.UsuarioRepository;

import java.util.List;


@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario obtenerUsuarioPorNomUsuario(
            String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorNomEmpleado(String nomempleado) {
        return usuarioRepository.findByEmpleadoNombre(nomempleado);
    }
}
