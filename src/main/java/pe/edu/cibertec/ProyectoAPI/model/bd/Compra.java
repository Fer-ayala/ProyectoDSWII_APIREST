package pe.edu.cibertec.ProyectoAPI.model.bd;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcompra;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "montocompra")
    private Double montoCompra;

    @JsonManagedReference
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleCompra> detallecompras;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;
}
