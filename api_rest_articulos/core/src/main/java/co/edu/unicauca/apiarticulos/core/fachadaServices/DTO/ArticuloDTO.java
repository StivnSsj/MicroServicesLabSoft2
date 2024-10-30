package co.edu.unicauca.apiarticulos.core.fachadaServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
/**
 * Clase de transferencia de datos (DTO) que representa un artículo en el sistema.
 * Incluye la información principal del artículo, como su título, resumen, palabras clave,
 * autores y la conferencia asociada.
 */
@Getter
@Setter
@AllArgsConstructor

public class ArticuloDTO {
    /**
     * Identificador único del artículo.
     */
    private Integer id;
    /**
     * Título descriptivo del artículo.
     */
    private String titulo;
    /**
     * Resumen breve del contenido del artículo.
     */
    private String resumen;
    /**
     * Palabras clave que describen los temas del artículo, utilizadas para facilitar la búsqueda.
     */
    private String palabrasClave;
    /**
     * Lista de identificadores de los autores que contribuyeron al artículo.
     */
    private List<Integer> autores;
    /**
     * Objeto `ConferenciaDTO` que representa la conferencia a la cual se presenta el artículo.
     */
    private ConferenciaDTO conferencia;

    /**
     * Constructor sin argumentos.
     */
    public ArticuloDTO() {
        
    } 
}
