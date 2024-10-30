/**
 * Interface que define los métodos para gestionar usuarios y sus conferencias.
 * Proporciona operaciones CRUD y métodos adicionales para el manejo de usuarios.
 */
package co.edu.unicauca.apiusuarios.core.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.CRUDUsuariosDTO.UsuarioDTO;
import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.UsuariosConConferenciasDTO.ConferenciaDTO;

public interface IUSuarioService {
    /**
     * Obtiene todos los usuarios registrados en el sistema.
     *
     * @return Lista de todos los objetos UsuarioDTO.
     */
    public List<UsuarioDTO> findAll();
    /**
     * Busca un usuario por su ID.
     *
     * @param id ID del usuario a buscar.
     * @return Objeto UsuarioDTO si se encuentra, de lo contrario null.
     */
    public UsuarioDTO findById(Integer id);
    /**
     * Almacena un nuevo usuario en el sistema.
     *
     * @param usuario Objeto UsuarioDTO a almacenar.
     * @return Objeto UsuarioDTO guardado.
     * @throws IllegalAccessException si ocurren problemas de acceso durante la operación.
     */
    public UsuarioDTO save(UsuarioDTO usuario) throws IllegalAccessException;
    /**
     * Actualiza un usuario existente identificado por su ID.
     *
     * @param id ID del usuario a actualizar.
     * @param usuario Objeto UsuarioDTO con la información actualizada.
     * @return Objeto UsuarioDTO actualizado.
     */
    public UsuarioDTO update(Integer id, UsuarioDTO usuario);
    /**
     * Elimina un usuario del sistema identificado por su ID.
     *
     * @param id ID del usuario a eliminar.
     * @return true si se eliminó correctamente, false en caso contrario.
     */
    public boolean delete(Integer id);
    /**
     * Lista las conferencias asociadas a un usuario específico.
     *
     * @param idUsuario ID del usuario cuyas conferencias se desean listar.
     * @return Lista de objetos ConferenciaDTO representando las conferencias del usuario.
     */
    public List<ConferenciaDTO> ListarConferenciasDeUsuario(Integer idUsuario);
    
    /**
     * Valida si un usuario tiene un rol específico.
     *
     * @param idUsuario ID del usuario.
     * @param rol Nombre del rol a validar.
     * @return true si el usuario tiene el rol, false en caso contrario.
     */
    public boolean validarRol(Integer idUsuario, String rol);
}

