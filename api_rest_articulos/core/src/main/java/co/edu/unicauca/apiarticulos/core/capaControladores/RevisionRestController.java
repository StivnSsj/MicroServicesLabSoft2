package co.edu.unicauca.apiarticulos.core.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.RevisionDTO;
import co.edu.unicauca.apiarticulos.core.fachadaServices.services.IRevisionService;

@RestController
@RequestMapping ("/api")
public class RevisionRestController {
    @Autowired
    private IRevisionService revisionService;
    /**
     * Lista todas las revisiones.
     * @return Lista de `RevisionDTO` con todas las revisiones.
     */
    @GetMapping("/revisiones")
    public List<RevisionDTO> listarRevisiones() {
        return revisionService.findAll();
    }
    /**
     * Busca una revisión por ID.
     * @param id Identificador único de la revisión.
     * @return `RevisionDTO` correspondiente al ID o `null` si no existe.
     */
    @GetMapping("/revisiones/{id}")
    public RevisionDTO consultarRevision(@PathVariable Integer id) {
		RevisionDTO objRevision = null;
		objRevision = revisionService.findById(id);
		return objRevision;
	}
    /**
     * Crea una nueva revisión.
     * @param revision Objeto `RevisionDTO` con la información de la revisión.
     * @param idUsuario ID del usuario que crea la revisión.
     * @return La revisión creada como `RevisionDTO`.
     */
    @PostMapping("/revisiones")
    public RevisionDTO crearRevision(@RequestBody RevisionDTO revision, @RequestParam Integer idUsuario) {
    RevisionDTO objRevision = revisionService.save(revision, idUsuario);
    return objRevision;
    }
    /**
     * Actualiza una revisión existente.
     * @param id Identificador único de la revisión.
     * @param revision Objeto `RevisionDTO` con la nueva información.
     * @return `RevisionDTO` actualizado o `null` si no se encuentra.
     */
    @PutMapping("/revisiones/{id}")
    public RevisionDTO actualizarRevision(@RequestBody RevisionDTO revision, @PathVariable Integer id) {
        return revisionService.update(id, revision);
    }
    /**
     * Elimina una revisión por ID.
     * @param id Identificador único de la revisión.
     * @return `true` si la revisión se eliminó, `false` si no se encontró.
     */
    @DeleteMapping("/revisiones/{id}")
    public boolean eliminarRevision(@PathVariable Integer id) {
        return revisionService.delete(id);
    }
    /**
     * Agrega un comentario a una revisión específica.
     * @param idRevision ID de la revisión.
     * @param comentario Comentario a agregar.
     * @param idUsuario ID del usuario que agrega el comentario.
     * @return `ResponseEntity` con la revisión actualizada o `NOT_FOUND` si la revisión no existe.
     */
    @PutMapping("revisiones/{idRevision}/comentario")
    public ResponseEntity<RevisionDTO> agregarComentario(@PathVariable Integer idRevision, @RequestBody String comentario, @RequestParam Integer idUsuario) {
        RevisionDTO revisionConComentario = revisionService.agregarComentario(idRevision, idUsuario, comentario);
        if (revisionConComentario != null)
            return ResponseEntity.ok(revisionConComentario);
        else 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /**
     * Actualiza el estado de una revisión específica.
     * @param idRevision ID de la revisión.
     * @param estado Nuevo estado a asignar.
     * @return `ResponseEntity` con la revisión actualizada o `NOT_FOUND` si la revisión no existe.
     */

    @PutMapping("revisiones/{id}/estado")
    public ResponseEntity<RevisionDTO> actualizarEstado(@PathVariable Integer id, @RequestBody String estado) {
        RevisionDTO revisionActualizada = revisionService.actualizarEstado(id, estado);
        if (revisionActualizada != null)
            return ResponseEntity.ok(revisionActualizada);
        else 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}