package api.baldini.discografia.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class DiscoResponse {
    private Long id;
    private String titulo;
    private Date fechaPublicacion;

}
