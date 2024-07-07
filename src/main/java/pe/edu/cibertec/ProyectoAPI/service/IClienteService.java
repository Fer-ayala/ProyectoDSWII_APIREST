package pe.edu.cibertec.ProyectoAPI.service;

import pe.edu.cibertec.ProyectoAPI.model.bd.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    List<Cliente> obtenerClientes();
    Cliente guardarCliente(Cliente cliente);
    Optional<Cliente> buscarClientexId(int id);

}
