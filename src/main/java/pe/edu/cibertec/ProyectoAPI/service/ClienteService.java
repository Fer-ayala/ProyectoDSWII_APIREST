package pe.edu.cibertec.ProyectoAPI.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoAPI.model.bd.Cliente;
import pe.edu.cibertec.ProyectoAPI.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteService implements IClienteService{

    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarClientexId(int id) {
        return clienteRepository.findById(id);
    }
}
