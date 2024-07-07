package pe.edu.cibertec.ProyectoAPI.controller;

import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("registrar")
    public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente){
        return new ResponseEntity<>(iClienteService.guardarCliente(cliente), HttpStatus.OK);
    }

}
