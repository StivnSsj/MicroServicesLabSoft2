/**
 * Representa la entidad de un rol en el sistema, usada para definir permisos y 
 * niveles de acceso de los usuarios.
 */
package co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * Clase RolEntity
 * Define la estructura de datos para un rol.
 * 
 * Atributos:
 * - id: Identificador único del rol.
 * - nombre: Nombre descriptivo del rol.
 * 
 * Constructor:
 * - RolEntity(): Constructor por defecto.
 */
@Getter @Setter @AllArgsConstructor
public class RolEntity {
    private Integer id;
    private String nombre;
    /**
     * Constructor por defecto para RolEntity.
     */
    public RolEntity(){
        
    }
}
