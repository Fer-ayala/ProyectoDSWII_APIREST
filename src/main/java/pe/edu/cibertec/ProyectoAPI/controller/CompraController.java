package pe.edu.cibertec.ProyectoAPI.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoAPI.model.bd.Compra;
import pe.edu.cibertec.ProyectoAPI.service.ICompraService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/compras")
public class CompraController {

    private ICompraService iCompraService;

    @GetMapping("/listar")
    public List<Compra> listarCompras(){
        return iCompraService.obtenerCompras();
    }

    @PreAuthorize("hasRole('CLIENTE')")
    @PostMapping("/registrar")
    public ResponseEntity<Compra> agregarCompra(@RequestBody Compra compra){
        return new ResponseEntity<>(iCompraService.guardarCompra(compra), HttpStatus.CREATED);
    }



}
