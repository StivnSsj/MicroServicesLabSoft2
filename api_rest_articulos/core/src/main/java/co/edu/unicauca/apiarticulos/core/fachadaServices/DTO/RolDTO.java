package co.edu.unicauca.apiarticulos.core.fachadaServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * Clase de transferencia de datos (DTO) que representa un rol en el sistema.
 * 
 * La clase `RolDTO` se utiliza para transferir información de un rol específico, facilitando el
 * intercambio de datos entre las diferentes capas de la aplicación.
 */
@Getter @Setter @AllArgsConstructor
public class RolDTO {
    /**
     * Nombre del rol asignado (e.g., "Autor", "Evaluador", "Organizador").
     */
    private String nombre;
    /**
     * Constructor sin argumentos necesario para la serialización y deserialización de objetos.
     */
    public RolDTO() {
        
    }
}
