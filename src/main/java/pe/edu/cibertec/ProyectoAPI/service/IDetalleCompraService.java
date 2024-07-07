package pe.edu.cibertec.ProyectoAPI.service;

import pe.edu.cibertec.ProyectoAPI.model.bd.DetalleCompra;

import java.util.List;
import java.util.Optional;

public interface IDetalleCompraService {
    List<DetalleCompra> obtenerDetalleCompras();
    DetalleCompra guardarDetalleCompra(DetalleCompra detalleCompra);
    Optional<DetalleCompra> buscarDetalleCompraPorId(int id);

}
