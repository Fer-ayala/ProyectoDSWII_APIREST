package pe.edu.cibertec.ProyectoAPI.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
