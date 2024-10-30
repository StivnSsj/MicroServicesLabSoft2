package co.edu.unicauca.apiarticulos.core.fachadaServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * Clase de transferencia de datos (DTO) que representa una conferencia en el sistema.
 * 
 * Esta clase se utiliza para transferir los datos básicos de una conferencia, permitiendo
 * una integración eficiente con la API y facilitando la vinculación de artículos a conferencias específicas.
 */
@Getter @Setter @AllArgsConstructor
public class ConferenciaDTO {
    /**
     * Identificador único de la conferencia.
     */
    private Integer id;
    /**
     * Constructor sin argumentos necesario para la serialización y deserialización de objetos.
     */
    public ConferenciaDTO() {
        
    }
}
