/**
 * Data Transfer Object (DTO) para representar una Conferencia.
 * Esta clase contiene información detallada de una conferencia,
 * incluyendo su identificador, nombre, fechas de inicio y fin, y ubicación.
 */
package co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.UsuariosConConferenciasDTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenciaDTO {
    private Integer id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String ubicacion;
    /**
     * Constructor sin argumentos.
     */
    public ConferenciaDTO(){
    
    }
}