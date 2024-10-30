/**
 * Controlador REST para gestionar operaciones CRUD sobre usuarios.
 * Define endpoints para obtener, crear, actualizar, eliminar y verificar el rol de usuarios.
 * Utiliza el servicio IUsuarioService para realizar las operaciones necesarias.
 */
package co.edu.unicauca.apiusuarios.core.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.CRUDUsuariosDTO.UsuarioDTO;
import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.UsuariosConConferenciasDTO.ConferenciaDTO;
import co.edu.unicauca.apiusuarios.core.fachadaServices.services.IUSuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    @Autowired
    private IUSuarioService usuarioService;
    /**
     * Obtiene todos los usuarios.
     * @return Lista de usuarios (UsuarioDTO).
     */
    @GetMapping("/usuarios")
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.findAll();
    }
    /**
     * Lista las conferencias asociadas a un usuario.
     * @param idUsuario Identificador único del usuario.
     * @return Lista de conferencias (ConferenciaDTO) del usuario.
     */

    @GetMapping("/usuarios/conferencias/{idUsuario}")
    public List<ConferenciaDTO> listarUsuarioConSusConferencias(@PathVariable Integer idUsuario) {
        return usuarioService.ListarConferenciasDeUsuario(idUsuario);
    }
    /**
     * Consulta un usuario por su ID.
     * @param id Identificador único del usuario.
     * @return Objeto UsuarioDTO si se encuentra el usuario, o null si no existe.
     */
    @GetMapping("/usuarios/{id}")
    public UsuarioDTO consultarUsuario(@PathVariable Integer id) {
        UsuarioDTO objUsuario = null;
        objUsuario = usuarioService.findById(id);
        return objUsuario;
    }
     /**
     * Crea un nuevo usuario.
     * @param usuario Objeto UsuarioDTO a ser creado.
     * @return Objeto UsuarioDTO del usuario creado.
     */
        
    @PostMapping("/usuarios")
    public UsuarioDTO crearUsuario(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO objUsuario = null;
        try {
            objUsuario = usuarioService.save(usuario);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return objUsuario;
    }
    /**
     * Actualiza un usuario existente.
     * @param id Identificador del usuario a actualizar.
     * @param usuario Objeto UsuarioDTO con los nuevos datos.
     * @return El usuario actualizado, o null si no se encontró el usuario.
     */
    
    @PutMapping("/usuarios/{id}")
    public UsuarioDTO actualizarUsuario(@RequestBody UsuarioDTO usuario, @PathVariable Integer id){
        UsuarioDTO objUsuario = null;
        UsuarioDTO usuarioActual = usuarioService.findById(id);
        if (usuarioActual != null)
            objUsuario = usuarioService.update(id, usuario);
        return objUsuario;
    }
    /**
     * Elimina un usuario por su ID.
     * @param id Identificador del usuario a eliminar.
     * @return true si el usuario fue eliminado, false si no se encontró el usuario.
     */
    @DeleteMapping("/usuarios/{id}")
    public Boolean eliminarUsuario(@PathVariable Integer id) {
        Boolean bandera = false;
        UsuarioDTO usuarioActual = usuarioService.findById(id);
        if (usuarioActual != null)
            bandera = usuarioService.delete(id);
        return bandera;
    }
    /**
     * Valida si el usuario tiene un rol específico.
     * @param idUsuario Identificador único del usuario.
     * @param rol Nombre del rol a validar.
     * @return ResponseEntity con true si el usuario tiene el rol, false en caso contrario.
     */
    @GetMapping("/usuarios/{idUsuario}/validarRol")
    public ResponseEntity<Boolean> validarRol(@PathVariable Integer idUsuario, @RequestParam String rol) {
        boolean validarRol = usuarioService.validarRol(idUsuario, rol);
        return ResponseEntity.ok(validarRol);
    }

    @GetMapping("/usuarios/rol/{idUsuario}")
    public String consultarRol(@PathVariable Integer idUsuario) {
        UsuarioDTO objUsuario = null;
        objUsuario = usuarioService.findById(idUsuario);
        String nombreRol = objUsuario.getRol().getNombre();
        return nombreRol;
    }
    
}
