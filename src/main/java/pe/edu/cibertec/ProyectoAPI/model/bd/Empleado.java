package pe.edu.cibertec.ProyectoAPI.model.bd;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idempleado;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;

    @Column(name = "direccion", length = 80)
    private String direccion;

    @Column(name = "telefono", length = 9)
    private String telefono;

    @Column(name = "email", length = 40)
    private String email;

    @Column(name = "fechacontratacion", nullable = false)
    private Date fechaContratacion;

    @ManyToOne
    @JoinColumn(name = "idrol")
    private Rol rol;

    @OneToOne(mappedBy = "empleado")
    private Usuario usuario;
}
