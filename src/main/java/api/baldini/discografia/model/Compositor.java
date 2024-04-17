package api.baldini.discografia.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Compositores")
@Data
public class Compositor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nombre;
    @Column
    private String nacionalidad;
    @Column
    private String descripcion;
}
