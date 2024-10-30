package co.edu.unicauca.apiusuarios.core.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models.RolEntity;
import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models.UsuarioEntity;
import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.repositories.RolRepository;
import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.repositories.UsuarioRepository;
import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.CRUDUsuariosDTO.UsuarioDTO;
import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.UsuariosConConferenciasDTO.ConferenciaDTO;
/**
 * Implementación del servicio para la gestión de usuarios.
 * Esta clase proporciona métodos para realizar operaciones CRUD sobre los usuarios
 * y gestionar su relación con los roles y conferencias.
 */
@Service
public class UsuarioServiceImpl implements IUSuarioService {
   
    @Autowired
    private UsuarioRepository servicioAccesoBaseDatos;

    @Autowired
    private RolRepository servicioAccesoDatosRol;

    @Autowired
    private ConferenciasService servicioConsumirObtencionConferencias;

    @Autowired
    private ModelMapper modelMapper;
    /**
     * Obtiene todos los usuarios en formato DTO.
     *
     * @return Lista de objetos UsuarioDTO que representan los usuarios disponibles.
     */
    @Override
    public List<UsuarioDTO> findAll() {
        List<UsuarioEntity> usuariosEntity = this.servicioAccesoBaseDatos.findAll();
        List<UsuarioDTO> usuariosDTO = this.modelMapper.map(usuariosEntity, new TypeToken<List<UsuarioDTO>>() {}.getType());
        return usuariosDTO;
    }
    /**
     * Busca un usuario por su ID y devuelve su representación en formato DTO.
     *
     * @param id Identificador del usuario a buscar.
     * @return UsuarioDTO que representa el usuario encontrado.
     */

    @Override
    public UsuarioDTO findById(Integer id) {
        UsuarioEntity objUsuarioEntity = this.servicioAccesoBaseDatos.findById(id);
        UsuarioDTO usuarioDTO = this.modelMapper.map(objUsuarioEntity, UsuarioDTO.class);
        return usuarioDTO;
    }
    /**
     * Guarda un nuevo usuario y devuelve su representación en formato DTO.
     *
     * @param usuario UsuarioDTO que representa el usuario a guardar.
     * @return UsuarioDTO que representa el usuario guardado.
     * @throws IllegalAccessException si el rol del usuario no es válido.
     */

    @Override
    public UsuarioDTO save(UsuarioDTO usuario) throws IllegalAccessException {
        // Validar si el rol existe}
        Integer rolId = usuario.getRol() != null ? usuario.getRol().getId() : null;
        if (rolId == null)
            throw new IllegalAccessException("El rol no puede ser nulo");
        
        RolEntity rolEntity = this.servicioAccesoDatosRol.findById(rolId);
        if (rolEntity == null)
            throw new IllegalAccessException("El rol con ID " + rolId + " no existe");
        
        UsuarioEntity usuarioEntity = this.modelMapper.map(usuario, UsuarioEntity.class);
        usuarioEntity.setRol(rolEntity);
        UsuarioEntity objUsuarioEntity = this.servicioAccesoBaseDatos.save(usuarioEntity);
        UsuarioDTO usuarioDTO = this.modelMapper.map(objUsuarioEntity, UsuarioDTO.class);
        return usuarioDTO;
    }
    /**
     * Actualiza un usuario existente y devuelve su nueva representación en formato DTO.
     *
     * @param id Identificador del usuario a actualizar.
     * @param usuario UsuarioDTO que contiene los nuevos datos del usuario.
     * @return UsuarioDTO que representa el usuario actualizado.
     */
    @Override
    public UsuarioDTO update(Integer id, UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = this.modelMapper.map(usuario, UsuarioEntity.class);
        UsuarioEntity objUsuarioEntity = this.servicioAccesoBaseDatos.update(id, usuarioEntity);
        UsuarioDTO usuarioDTO = this.modelMapper.map(objUsuarioEntity, UsuarioDTO.class);
        return usuarioDTO;
    }
    /**
     * Elimina un usuario por su ID.
     *
     * @param id Identificador del usuario a eliminar.
     * @return true si se eliminó con éxito, false en caso contrario.
     */
    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }
    /**
     * Lista las conferencias asociadas a un usuario.
     *
     * @param idUsuario Identificador del usuario.
     * @return Lista de objetos ConferenciaDTO que representan las conferencias del usuario.
     */
    @Override
    public List<ConferenciaDTO> ListarConferenciasDeUsuario(Integer idUsuario) {
        List<ConferenciaDTO> listaConferenciasDelUsuario;
        listaConferenciasDelUsuario = this.servicioConsumirObtencionConferencias.obtenerConferenciasDeUsuario(idUsuario);
        return listaConferenciasDelUsuario;
    }
    /**
     * Valida si un usuario tiene un rol específico.
     *
     * @param idUsuario Identificador del usuario a validar.
     * @param rol Nombre del rol a validar.
     * @return true si el usuario tiene el rol, false en caso contrario.
     */
    @Override
    public boolean validarRol(Integer idUsuario, String rol) {
        UsuarioEntity usuario = this.servicioAccesoBaseDatos.findById(idUsuario);
        return usuario != null && usuario.getRol().getNombre().equals(rol);
    }
}
