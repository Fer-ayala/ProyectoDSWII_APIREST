package pe.edu.cibertec.ProyectoAPI.service;

import pe.edu.cibertec.ProyectoAPI.model.bd.Compra;

import java.util.List;
import java.util.Optional;

public interface ICompraService {
    List<Compra> obtenerCompras();
    Compra guardarCompra(Compra compra);
    Optional<Compra> buscarComprasPorId(int id);
}
