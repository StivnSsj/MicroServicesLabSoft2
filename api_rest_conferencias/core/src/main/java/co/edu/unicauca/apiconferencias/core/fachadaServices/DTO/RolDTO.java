package co.edu.unicauca.apiconferencias.core.fachadaServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * DTO para representar la entidad Rol en transferencias de datos.
 * Define el rol de un usuario en el sistema, especificando únicamente el nombre.
 */
@Getter @Setter @AllArgsConstructor
public class RolDTO {
    private String nombre;

    /**
     * Constructor sin argumentos requerido para serialización/deserialización.
     */
    public RolDTO() {
        
    }
}
