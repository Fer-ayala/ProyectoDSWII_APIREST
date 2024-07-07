package pe.edu.cibertec.ProyectoAPI.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.ProyectoAPI.model.bd.Usuario;
import pe.edu.cibertec.ProyectoAPI.service.UsuarioService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuariosController {

    private UsuarioService usuarioService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public List<Usuario> listarUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

}
