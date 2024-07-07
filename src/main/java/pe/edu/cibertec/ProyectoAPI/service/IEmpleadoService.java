package pe.edu.cibertec.ProyectoAPI.service;

import pe.edu.cibertec.ProyectoAPI.model.bd.Empleado;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {
    List<Empleado> obtenerEmpleados();
    Empleado agregarEmpleado(Empleado empleado);
    Optional<Empleado> buscarEmpleadoxId(int id);
}
