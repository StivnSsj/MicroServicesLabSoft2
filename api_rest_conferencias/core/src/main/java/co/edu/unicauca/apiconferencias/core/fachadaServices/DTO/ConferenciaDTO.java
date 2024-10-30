package co.edu.unicauca.apiconferencias.core.fachadaServices.DTO;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO para representar la entidad Conferencia en transferencias de datos.
 * Contiene los datos de una conferencia, como nombre, fechas y ubicación.
 */
@Getter
@Setter
@AllArgsConstructor

public class ConferenciaDTO {
    private Integer id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String ubicacion;
    private List<Integer> articulos;

    /**
     * Constructor sin argumentos requerido para serialización/deserialización.
     */
    public ConferenciaDTO(){
        
    }
}
