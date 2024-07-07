package pe.edu.cibertec.ProyectoAPI.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.ProyectoAPI.model.bd.Inventario;
import pe.edu.cibertec.ProyectoAPI.service.IInventarioService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/inventario")
public class InventarioController {

    private IInventarioService iInventarioService;

    @GetMapping("/listar")
    public List<Inventario> listarInventario(){
        return iInventarioService.obtenerInventarios();
    }

}
