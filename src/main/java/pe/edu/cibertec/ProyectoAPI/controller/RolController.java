package pe.edu.cibertec.ProyectoAPI.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.ProyectoAPI.model.bd.Rol;
import pe.edu.cibertec.ProyectoAPI.service.IRolService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/roles")
public class RolController {

    private IRolService iRolService;

    @GetMapping("/listar")
    public List<Rol> listarRoles(){
        return iRolService.obtenerRoles();
    }

}
