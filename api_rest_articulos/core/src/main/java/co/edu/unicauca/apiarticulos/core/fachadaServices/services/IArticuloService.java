package co.edu.unicauca.apiarticulos.core.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.ArticuloDTO;

/**
 * Interfaz que define los servicios para la gestión de artículos.
 * 
 * La interfaz `IArticuloService` establece los métodos necesarios para realizar
 * operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre los artículos.
 * Esta interfaz es implementada por la clase `ArticuloServiceImpl`, proporcionando
 * la lógica de negocio para la manipulación de datos relacionados con artículos.
 */
public interface IArticuloService {
	/**
     * Obtiene todos los artículos disponibles.
     * 
     * @return Lista de objetos `ArticuloDTO` que representan todos los artículos.
     */
	public List<ArticuloDTO> findAll();
	/**
     * Busca un artículo por su identificador.
     * 
     * @param id Identificador del artículo a buscar.
     * @return El objeto `ArticuloDTO` correspondiente al artículo encontrado, o null si no se encuentra.
     */
	public ArticuloDTO findById(Integer id);
	/**
     * Verifica si un artículo existe por su identificador.
     * 
     * @param id Identificador del artículo a verificar.
     * @return El objeto `ArticuloDTO` correspondiente al artículo encontrado, o null si no se encuentra.
     */
	public ArticuloDTO exist(Integer id);
	 /**
     * Guarda un nuevo artículo en el sistema.
     * 
     * @param articulo Objeto `ArticuloDTO` que contiene la información del artículo a guardar.
     * @param idUsuario Identificador del usuario que está guardando el artículo.
     * @return El objeto `ArticuloDTO` que representa el artículo guardado, incluyendo su identificador.
     */
	public ArticuloDTO save(ArticuloDTO articulo, Integer idUsuario);
	/**
     * Actualiza la información de un artículo existente.
     * 
     * @param id Identificador del artículo a actualizar.
     * @param articulo Objeto `ArticuloDTO` que contiene la nueva información del artículo.
     * @return El objeto `ArticuloDTO` que representa el artículo actualizado.
     */
	public ArticuloDTO update(Integer id, ArticuloDTO articulo);
	/**
     * Elimina un artículo del sistema.
     * 
     * @param id Identificador del artículo a eliminar.
     * @return true si el artículo fue eliminado exitosamente, false en caso contrario.
     */
	public boolean delete(Integer id);
}
