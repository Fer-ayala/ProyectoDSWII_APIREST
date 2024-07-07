package pe.edu.cibertec.ProyectoAPI.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.ProyectoAPI.model.bd.DetalleCompra;
import pe.edu.cibertec.ProyectoAPI.service.IDetalleCompraService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/detallescompra")
public class DetalleCompraController {

    private IDetalleCompraService iDetalleCompraService;

    @GetMapping("/listar")
    public List<DetalleCompra> listarDetallesCompra(){
        return iDetalleCompraService.obtenerDetalleCompras();
    }

}
