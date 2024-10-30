/**
 * Clase que implementa la interfaz IRolServicie.
 * Proporciona las operaciones CRUD para gestionar roles de usuario.
 */
package co.edu.unicauca.apiusuarios.core.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models.RolEntity;
import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.repositories.RolRepository;
import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.CRUDUsuariosDTO.RolDTO;

@Service
public class RolServiceImpl implements IRolServicie {
    
    @Autowired
    private RolRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;
    /**
     * Obtiene todos los roles en formato DTO.
     *
     * @return Lista de objetos RolDTO que representan los roles disponibles.
     */
    @Override
    public List<RolDTO> findAll() {
        // Obtiene todos los roles de la base de datos y los convierte a DTOs.
        List<RolEntity> rolesEntity = this.servicioAccesoBaseDatos.findAll();
        List<RolDTO> rolesDTO = this.modelMapper.map(rolesEntity, new TypeToken<List<RolDTO>>() {}.getType());
        return rolesDTO;
    }
    /**
     * Guarda un nuevo rol y devuelve su representación en formato DTO.
     *
     * @param rol RolDTO que representa el rol a guardar.
     * @return RolDTO que representa el rol guardado.
     */

    @Override
    public RolDTO save(RolDTO rol){
        RolEntity rolEntity = this.modelMapper.map(rol, RolEntity.class);
        RolEntity objRolEntity = this.servicioAccesoBaseDatos.save(rolEntity);
        RolDTO rolDTO = this.modelMapper.map(objRolEntity, RolDTO.class);
        return rolDTO;
    }
    /**
     * Busca un rol por su ID y devuelve su representación en formato DTO.
     *
     * @param id Identificador del rol a buscar.
     * @return RolDTO que representa el rol encontrado.
     */

    @Override
    public RolDTO findById(Integer id) {
        RolEntity objEntity = this.servicioAccesoBaseDatos.findById(id);
        RolDTO rolDTO = this.modelMapper.map(objEntity, RolDTO.class);
        return rolDTO;
    }
    /**
     * Actualiza un rol existente y devuelve su nueva representación en formato DTO.
     *
     * @param id Identificador del rol a actualizar.
     * @param rol RolDTO que contiene los nuevos datos del rol.
     * @return RolDTO que representa el rol actualizado.
     */

    @Override
    public RolDTO update(Integer id, RolDTO rol) {
        RolEntity rolEntity = this.modelMapper.map(rol, RolEntity.class);
        RolEntity objRolEntity = this.servicioAccesoBaseDatos.update(id, rolEntity);
        RolDTO rolDTO = this.modelMapper.map(objRolEntity, RolDTO.class);
        return rolDTO;
    }
    /**
     * Elimina un rol por su ID.
     *
     * @param id Identificador del rol a eliminar.
     * @return true si se eliminó con éxito, false en caso contrario.
     */ 

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }
}
