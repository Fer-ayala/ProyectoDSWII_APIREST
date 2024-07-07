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
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcliente;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 50, nullable = false)
    private String apellido;

    @Column(name = "direccion", length = 100)
    private String direccion;

    @Column(name = "telefono", length = 9)
    private String telefono;

    @Column(name = "correoelectronico", length = 40)
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Compra> compras;
}
