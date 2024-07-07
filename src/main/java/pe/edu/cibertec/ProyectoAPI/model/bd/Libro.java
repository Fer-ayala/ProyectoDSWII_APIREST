package pe.edu.cibertec.ProyectoAPI.model.bd;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Titulo", length = 80, nullable = false)
    private String titulo;

    @Column(name = "Autor", length = 80, nullable = false)
    private String autor;

    @Column(name = "editorial", length = 100, nullable = false)
    private String editorial;

    @Column(name = "fechapublicacion", nullable = false)
    private Date fechaPublicacion;

    @Column(name = "genero", length = 30, nullable = false)
    private String genero;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleCompra> detallescompra;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "lib", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Inventario> inventarios;
}
