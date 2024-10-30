/**
 * Interface que define los métodos para gestionar roles de usuario.
 * Esta interfaz proporciona las operaciones CRUD para el manejo de roles.
 */
package co.edu.unicauca.apiusuarios.core.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.CRUDUsuariosDTO.RolDTO;

public interface IRolServicie {
    /**
     * Obtiene todos los roles registrados en el sistema.
     *
     * @return Lista de todos los objetos RolDTO.
     */
    public List<RolDTO> findAll();
    /**
     * Busca un rol por su ID.
     *
     * @param id ID del rol a buscar.
     * @return Objeto RolDTO si se encuentra, de lo contrario null.
     */
    public RolDTO findById(Integer id);
    /**
     * Almacena un nuevo rol en el sistema.
     *
     * @param rol Objeto RolDTO a almacenar.
     * @return Objeto RolDTO guardado.
     */
    public RolDTO save(RolDTO rol);
    /**
     * Actualiza un rol existente identificado por su ID.
     *
     * @param id ID del rol a actualizar.
     * @param rol Objeto RolDTO con la información actualizada.
     * @return Objeto RolDTO actualizado.
     */
    public RolDTO update(Integer id, RolDTO rol);
    /**
     * Elimina un rol del sistema identificado por su ID.
     *
     * @param id ID del rol a eliminar.
     * @return true si se eliminó correctamente, false en caso contrario.
     */
    public boolean delete(Integer id);
}
