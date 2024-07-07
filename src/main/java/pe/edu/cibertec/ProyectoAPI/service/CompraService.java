package pe.edu.cibertec.ProyectoAPI.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoAPI.model.bd.Compra;
import pe.edu.cibertec.ProyectoAPI.repository.CompraRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CompraService implements ICompraService{

    private CompraRepository compraRepository;

    @Override
    public List<Compra> obtenerCompras() {
        return compraRepository.findAll();
    }

    @Override
    public Compra guardarCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    @Override
    public Optional<Compra> buscarComprasPorId(int id) {
        return compraRepository.findById(id);
    }
}
