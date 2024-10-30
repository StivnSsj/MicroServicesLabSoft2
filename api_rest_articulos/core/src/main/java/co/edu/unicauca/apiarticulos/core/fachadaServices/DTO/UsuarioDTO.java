package co.edu.unicauca.apiarticulos.core.fachadaServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * Clase de transferencia de datos (DTO) que representa un usuario en el sistema.
 * 
 * La clase `UsuarioDTO` se utiliza para transferir información sobre un usuario específico, incluyendo
 * su identificador y el rol asociado, facilitando el intercambio de datos entre las diferentes capas de la aplicación.
 */
@Getter @Setter @AllArgsConstructor
public class UsuarioDTO {
    /**
     * Identificador único del usuario.
     */
    private Integer id;
    /**
     * Rol asignado al usuario, representado por un objeto de la clase `RolDTO`.
     */
    private RolDTO rol;
    /**
     * Constructor sin argumentos necesario para la serialización y deserialización de objetos.
     */
    public UsuarioDTO() {

    }
}
