package pe.edu.cibertec.ProyectoAPI.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrol;
    @Column(name = "nomrol")
    private String nomrol;
    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Empleado> empleados;
}