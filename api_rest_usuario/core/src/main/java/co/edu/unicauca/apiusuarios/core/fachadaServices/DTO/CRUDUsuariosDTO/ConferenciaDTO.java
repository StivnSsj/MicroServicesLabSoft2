/**
 * Data Transfer Object (DTO) para representar una Conferencia.
 * Esta clase contiene solo el identificador de la conferencia.
 */
package co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.CRUDUsuariosDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ConferenciaDTO {
    private Integer id;
    /**
     * Constructor sin argumentos.
     */
    public ConferenciaDTO() {
        
    }
}
