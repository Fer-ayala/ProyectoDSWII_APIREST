package pe.edu.cibertec.ProyectoAPI.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cantidadstock", nullable = false)
    private Integer cantidadStock;

    @Column(name = "fechaultimaactualizacion", nullable = false)
    private Date fechaUltimaActualizacion;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idlibro")
    private Libro lib;
}
