package co.edu.unicauca.apiarticulos.core.fachadaServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * Clase de transferencia de datos (DTO) que representa la información básica de un artículo 
 * en el contexto de una revisión.
 * 
 * Esta clase permite asociar un artículo a una revisión utilizando solo su identificador, 
 * optimizando la transferencia de datos en la API.
 */
@Getter @Setter @AllArgsConstructor
public class ArticuloRevisionDTO {
    /**
     * Identificador único del artículo, utilizado para vincularlo a una revisión específica.
     */
    private Integer id;
     /**
     * Constructor sin argumentos necesario para la serialización y deserialización de objetos.
     */
    public ArticuloRevisionDTO() {
        
    }
}
