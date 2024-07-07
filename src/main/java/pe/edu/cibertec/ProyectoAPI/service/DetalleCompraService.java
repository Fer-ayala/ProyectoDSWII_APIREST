package pe.edu.cibertec.ProyectoAPI.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoAPI.model.bd.DetalleCompra;
import pe.edu.cibertec.ProyectoAPI.repository.DetalleCompraRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DetalleCompraService implements IDetalleCompraService{

    private DetalleCompraRepository detalleCompraRepository;

    @Override
    public List<DetalleCompra> obtenerDetalleCompras() {
        return detalleCompraRepository.findAll();
    }

    @Override
    public DetalleCompra guardarDetalleCompra(DetalleCompra detalleCompra) {
        return detalleCompraRepository.save(detalleCompra);
    }

    @Override
    public Optional<DetalleCompra> buscarDetalleCompraPorId(int id) {
        return detalleCompraRepository.findById(id);
    }
}
