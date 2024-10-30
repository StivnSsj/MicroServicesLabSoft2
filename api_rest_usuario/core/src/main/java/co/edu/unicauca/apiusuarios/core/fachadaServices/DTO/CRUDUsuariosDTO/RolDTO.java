/**
 * Data Transfer Object (DTO) para representar un Rol de usuario.
 * Contiene el identificador y nombre del rol.
 */
package co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.CRUDUsuariosDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class RolDTO {
    private Integer id;
    private String nombre;

    /**
     * Constructor sin argumentos.
     */
    public RolDTO() {
        
    } 
}
