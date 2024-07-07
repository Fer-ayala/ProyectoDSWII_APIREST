package pe.edu.cibertec.ProyectoAPI.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoAPI.model.bd.Empleado;
import pe.edu.cibertec.ProyectoAPI.repository.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmpleadoService implements IEmpleadoService {

    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> obtenerEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado agregarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Optional<Empleado> buscarEmpleadoxId(int id) {
        return empleadoRepository.findById(id);
    }
}
