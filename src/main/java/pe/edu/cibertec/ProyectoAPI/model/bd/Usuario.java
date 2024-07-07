package pe.edu.cibertec.ProyectoAPI.model.bd;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    @Column(name = "nomusuario")
    private String nomusuario;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "activo")
    private Boolean activo;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idempleado")
    private Empleado empleado;

}
