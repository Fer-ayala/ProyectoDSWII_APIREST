package pe.edu.cibertec.ProyectoAPI.service;

import pe.edu.cibertec.ProyectoAPI.model.bd.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario obtenerUsuarioPorNomUsuario(
            String nomusuario);

    List<Usuario> obtenerUsuarios();

    Usuario obtenerUsuarioPorNomEmpleado(String nomempleado);
}
