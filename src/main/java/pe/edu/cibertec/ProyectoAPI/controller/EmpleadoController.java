package pe.edu.cibertec.ProyectoAPI.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.ProyectoAPI.model.bd.Empleado;
import pe.edu.cibertec.ProyectoAPI.service.IEmpleadoService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/empleados")
public class EmpleadoController {

    private IEmpleadoService iEmpleadoService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public List<Empleado> listarEmpleados(){
        return iEmpleadoService.obtenerEmpleados();
    };

}
