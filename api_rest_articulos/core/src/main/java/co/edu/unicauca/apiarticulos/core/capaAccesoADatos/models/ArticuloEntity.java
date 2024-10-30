package co.edu.unicauca.apiarticulos.core.capaAccesoADatos.models;
import java.util.List;

import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.ConferenciaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * Entidad que representa un artículo en el sistema.
 * Esta clase modela los datos de un artículo, incluyendo su título, resumen, palabras clave,
 * lista de IDs de autores, y la conferencia en la que fue o será presentado.
 */
@Getter @Setter @AllArgsConstructor
public class ArticuloEntity {
    private Integer id;
    private String titulo;
    private String resumen;
    private String palabrasClave;
    /**
     * Lista de identificadores de los autores del artículo.
     * Cada autor está representado por su ID.
     */
    private List<Integer> autores;
    /**
     * Objeto que representa la conferencia en la que se presentó o se presentará el artículo.
     */
    private ConferenciaDTO conferencia;
    /**
     * Constructor vacío requerido para la creación de instancias sin inicialización previa.
     */
    public ArticuloEntity() {

    }
}
