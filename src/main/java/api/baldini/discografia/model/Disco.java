package api.baldini.discografia.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "Discos")
@Entity
@Data
public class Disco {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String titulo;
    @Column
    private Date fechaPublicacion;


}
