/**
 * Representa la entidad de un usuario en el sistema, la cual contiene información
 * relevante para la autenticación y autorización del usuario.
 * Incluye detalles como su nombre, apellido, correo electrónico, contraseña y el rol asociado.
 */
package co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * Clase UsuarioEntity
 * Define la estructura de datos para un usuario.
 * 
 * Atributos:
 * - id: Identificador único del usuario.
 * - nombre: Nombre del usuario.
 * - apellido: Apellido del usuario.
 * - correo: Correo electrónico del usuario.
 * - password: Contraseña del usuario.
 * - rol: Rol asignado al usuario en el sistema (asociación con RolEntity).
 * 
 * Constructor:
 * - UsuarioEntity(): Constructor por defecto.
 */
@Getter
@Setter
@AllArgsConstructor
public class UsuarioEntity {
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;

    @NonNull
    private RolEntity rol;
    /**
     * Constructor por defecto para UsuarioEntity.
     */
    public UsuarioEntity() {

    }
}
