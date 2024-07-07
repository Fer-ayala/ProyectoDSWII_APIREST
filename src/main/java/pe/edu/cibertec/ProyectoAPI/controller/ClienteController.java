package pe.edu.cibertec.ProyectoAPI.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.ProyectoAPI.model.bd.Cliente;
import pe.edu.cibertec.ProyectoAPI.service.IClienteService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/clientes")
public class ClienteController {

    private IClienteService iClienteService;

    @GetMapping("listar")
    public List<Cliente> listarClientes(){
        return iClienteService.obtenerClientes();
    };

}
