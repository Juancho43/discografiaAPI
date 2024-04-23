package api.baldini.discografia.dtos;

import api.baldini.discografia.model.Compositor;
import api.baldini.discografia.model.Disco;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class DiscoRequest {
    private Long id;
    private String titulo;
    private Date fechaPublicacion;

}
