package co.edu.unicauca.apiarticulos.core.fachadaServices.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * Clase de transferencia de datos (DTO) que representa una revisión en el sistema.
 * 
 * Esta clase se utiliza para transferir la información de una revisión de un artículo, incluyendo los evaluadores asignados,
 * comentarios, y el estado de la revisión. Facilita el intercambio de datos entre las capas de la aplicación.
 */
@Getter @Setter @AllArgsConstructor
public class RevisionDTO {
    /**
     * Identificador único de la revisión.
     */
    private Integer id;
    /**
     * Información básica del artículo asociado a la revisión.
     */
    private ArticuloRevisionDTO Articulo;
    /**
     * Lista de identificadores de evaluadores asignados a la revisión.
     */
    private List<Integer> evaluadores;
    /**
     * Lista de comentarios realizados durante el proceso de revisión.
     */
    private List<String> comentarios;
    /**
     * Estado actual de la revisión (e.g., pendiente, en proceso, completado).
     */
    private String estado;
    /**
     * Constructor sin argumentos necesario para la serialización y deserialización de objetos.
     */
    public RevisionDTO() {
 
    } 
}
