/**
 * Controlador REST para gestionar operaciones CRUD sobre roles.
 * Define endpoints para obtener, crear, actualizar y eliminar roles.
 * Utiliza el servicio IRolService para realizar las operaciones necesarias.
 */
package co.edu.unicauca.apiusuarios.core.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.CRUDUsuariosDTO.RolDTO;
import co.edu.unicauca.apiusuarios.core.fachadaServices.services.IRolServicie;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class RolRestController {
    
    @Autowired
    private IRolServicie rolService;
    /**
     * Obtiene todos los roles.
     * @return Lista de roles (RolDTO).
     */
    @GetMapping("/roles")
    public List<RolDTO> listarRoles(){
        return rolService.findAll();
    }
    /**
     * Crea un nuevo rol.
     * @param rol Objeto RolDTO a ser creado.
     * @return Objeto RolDTO del rol creado.
     */
    @PostMapping("/roles")
    public RolDTO crearRol(@RequestBody RolDTO rol){
        RolDTO objRol = null;
        objRol = rolService.save(rol);
        return objRol;
    }
    /**
     * Consulta un rol por su ID.
     * @param id Identificador único del rol.
     * @return Objeto RolDTO si se encuentra el rol, o null si no existe.
     */
    @GetMapping("/roles/{id}")
    public RolDTO consultarRol(@PathVariable Integer id){
        RolDTO objRol = null;
        objRol = rolService.findById(id);
        return objRol;
    }
    /**
     * Actualiza un rol existente.
     * @param id Identificador del rol a actualizar.
     * @param rol Objeto RolDTO con los nuevos datos.
     * @return El rol actualizado, o null si no se encontró el rol.
     */
    @PutMapping("/roles/{id}")
    public RolDTO actualizarRol(@RequestBody RolDTO rol, @PathVariable Integer id) {
        RolDTO objRol = null;
        RolDTO rolActual = rolService.findById(id);
        if (rolActual != null)
            objRol = rolService.update(id, rol);
        return objRol;
    }
    /**
     * Elimina un rol por su ID.
     * @param id Identificador del rol a eliminar.
     * @return true si el rol fue eliminado, false si no se encontró el rol.
     */
    @DeleteMapping("/roles/{id}")
    public Boolean eliminarRol(@PathVariable Integer id){
        Boolean bandera = false;
        RolDTO rolActual = rolService.findById(id);
        if  (rolActual != null)
            bandera = rolService.delete(id);
        return bandera;
    }
}
