package pe.edu.cibertec.ProyectoAPI.model.bd;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detallecompra")

public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "preciounitario")
    private Double precioUnitario;

    @ManyToOne
    @JoinColumn(name = "idcompra")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "idlibro")
    private Libro libro;
}
