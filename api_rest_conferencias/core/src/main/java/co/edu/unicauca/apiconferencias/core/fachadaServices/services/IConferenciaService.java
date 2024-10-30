package co.edu.unicauca.apiconferencias.core.fachadaServices.services;
import java.util.List;

import co.edu.unicauca.apiconferencias.core.fachadaServices.DTO.ConferenciaDTO;

/**
 * Interfaz de servicio para la gestión de conferencias.
 * Define los métodos CRUD y operaciones adicionales para manejar conferencias.
 */
public interface IConferenciaService {
	/**
     * Obtiene una lista de todas las conferencias almacenadas.
     * @return una lista de objetos ConferenciaDTO que representan las conferencias.
     */
    public List<ConferenciaDTO> findAll();
	/**
     * Busca una conferencia específica por su ID.
     * @param id el ID de la conferencia a buscar.
     * @return un objeto ConferenciaDTO que representa la conferencia encontrada o null si no se encuentra.
     */
    public ConferenciaDTO findById(Integer id);

    public ConferenciaDTO findByNombre(String nombre);
	/**
     * Guarda una nueva conferencia en la base de datos.
     * Requiere que el usuario que realiza la operación tenga el rol de "ORGANIZADOR".
     * @param conferencia el DTO de la conferencia a guardar.
     * @param idUsuario el ID del usuario que intenta crear la conferencia.
     * @return un objeto ConferenciaDTO que representa la conferencia guardada.
     */
	public ConferenciaDTO save(ConferenciaDTO conferencia, Integer idUsuario);
	/**
     * Actualiza una conferencia existente en la base de datos.
     * @param id el ID de la conferencia a actualizar.
     * @param conferencia el DTO con los datos actualizados de la conferencia.
     * @return un objeto ConferenciaDTO que representa la conferencia actualizada.
     */
	public ConferenciaDTO update(Integer id, ConferenciaDTO conferencia);
	/**
     * Agrega un artículo a una conferencia específica.
     * @param idConferencia el ID de la conferencia a la que se agregará el artículo.
     * @param idArticulo el ID del artículo a agregar a la conferencia.
     * @return un objeto ConferenciaDTO que representa la conferencia actualizada con el artículo agregado.
     */
	public ConferenciaDTO agregarArticulo(Integer idConferencia, Integer idArticulo);
	/**
     * Elimina una conferencia de la base de datos.
     * @param id el ID de la conferencia a eliminar.
     * @return true si la conferencia fue eliminada exitosamente, false de lo contrario.
     */
	public boolean delete(Integer id);
    
    
     public ConferenciaDTO exist(Integer id);


     public int cantArticulos(Integer id);
}
