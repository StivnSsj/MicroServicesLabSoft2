package co.edu.unicauca.apiarticulos.core.fachadaServices.services;
import java.util.List;

import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.RevisionDTO;
/**
 * Interfaz que define los servicios para la gestión de revisiones de artículos.
 * 
 * La interfaz `IRevisionService` establece los métodos necesarios para realizar
 * operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre las revisiones
 * de artículos. Esta interfaz es implementada por una clase que proporciona
 * la lógica de negocio para la manipulación de datos relacionados con revisiones.
 */
public interface IRevisionService {
	/**
     * Obtiene todas las revisiones disponibles.
     * 
     * @return Lista de objetos `RevisionDTO` que representan todas las revisiones.
     */
	public List<RevisionDTO> findAll();
	/**
     * Busca una revisión por su identificador.
     * 
     * @param idRevision Identificador de la revisión a buscar.
     * @return El objeto `RevisionDTO` correspondiente a la revisión encontrada, o null si no se encuentra.
     */
	public RevisionDTO findById(Integer idRevision);
	  /**
     * Guarda una nueva revisión en el sistema.
     * 
     * @param revision Objeto `RevisionDTO` que contiene la información de la revisión a guardar.
     * @param idUsuario Identificador del usuario que está guardando la revisión.
     * @return El objeto `RevisionDTO` que representa la revisión guardada, incluyendo su identificador.
     */
	public RevisionDTO save(RevisionDTO revision, Integer idUsuario);
	/**
     * Actualiza la información de una revisión existente.
     * 
     * @param id Identificador de la revisión a actualizar.
     * @param revision Objeto `RevisionDTO` que contiene la nueva información de la revisión.
     * @return El objeto `RevisionDTO` que representa la revisión actualizada.
     */
	public RevisionDTO update(Integer id, RevisionDTO Revision);
	/**
     * Elimina una revisión del sistema.
     * 
     * @param id Identificador de la revisión a eliminar.
     * @return true si la revisión fue eliminada exitosamente, false en caso contrario.
     */
	public boolean delete(Integer id);
	/**
     * Agrega un comentario a una revisión existente.
     * 
     * @param idRevision Identificador de la revisión a la que se agregará el comentario.
     * @param idEvaluador Identificador del evaluador que hace el comentario.
     * @param comentario El texto del comentario a agregar.
     * @return El objeto `RevisionDTO` que representa la revisión actualizada con el nuevo comentario.
     */
	public RevisionDTO agregarComentario(Integer idRevision, Integer idEvaluador, String comentario);
	 /**
     * Actualiza el estado de una revisión existente.
     * 
     * @param idRevision Identificador de la revisión cuyo estado se actualizará.
     * @param estado Nuevo estado a establecer para la revisión.
     * @return El objeto `RevisionDTO` que representa la revisión actualizada con el nuevo estado.
     */
	public RevisionDTO actualizarEstado(Integer idRevision, String estado);
}
