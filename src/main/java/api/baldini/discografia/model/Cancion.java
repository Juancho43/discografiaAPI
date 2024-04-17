package api.baldini.discografia.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Table(name = "Canciones")
@Entity
@Data
public class Cancion{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToMany
    private List<Compositor> compositores;
    @ManyToMany
    private List<Disco> discos;
    @Column
    private String titulo;
    @Column
    private String duracion;
    @Column
    private String genero;

}
