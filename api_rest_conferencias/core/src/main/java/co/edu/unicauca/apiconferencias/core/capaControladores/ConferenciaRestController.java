package co.edu.unicauca.apiconferencias.core.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.apiconferencias.core.fachadaServices.DTO.ConferenciaDTO;
import co.edu.unicauca.apiconferencias.core.fachadaServices.services.IConferenciaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controlador REST para gestionar conferencias.
 * Permite realizar operaciones CRUD sobre conferencias a través de una API REST.
 */
@RestController
@RequestMapping ("/api")
public class ConferenciaRestController {

    @Autowired
	private IConferenciaService ConferenciaService;
    /**
     * Endpoint para listar todas las conferencias.
     *
     * @return Lista de objetos ConferenciaDTO que representan todas las conferencias.
     */
    @GetMapping("/conferencias")
    public List<ConferenciaDTO> listarConferencias() {
		return ConferenciaService.findAll();
    }
    /**
     * Endpoint para consultar una conferencia específica por su ID.
     *
     * @param id Identificador de la conferencia a consultar.
     * @return Objeto ConferenciaDTO que representa la conferencia encontrada.
     */
    @GetMapping("/conferencias/{id}")
	public ConferenciaDTO consultarConferencia(@PathVariable Integer id) {
		ConferenciaDTO objConferencia = null;
		objConferencia = ConferenciaService.findById(id);
		return objConferencia;
	}

    /**
     * Endpoint para crear una nueva conferencia.
     *
     * @param conferencia Objeto ConferenciaDTO con los datos de la conferencia a crear.
     * @param idUsuario Identificador del usuario que crea la conferencia.
     * @return Objeto ConferenciaDTO que representa la conferencia creada.
     */
    @PostMapping("/conferencias")
	public ConferenciaDTO crearConferencia(@RequestBody ConferenciaDTO conferencia, @RequestParam Integer idUsuario) {
        ConferenciaDTO objConferencia = null;
		objConferencia = ConferenciaService.save(conferencia, idUsuario);
		return objConferencia;
	}
    /**
     * Endpoint para actualizar una conferencia existente.
     *
     * @param id Identificador de la conferencia a actualizar.
     * @param conferencia Objeto ConferenciaDTO con los datos actualizados de la conferencia.
     * @return Respuesta HTTP con el objeto ConferenciaDTO actualizado y estado OK, o NOT_FOUND si la conferencia no existe.
     */
    @PutMapping("/conferencias/{id}")
    public ResponseEntity<ConferenciaDTO> actualizarConferencia(@PathVariable Integer id, @RequestBody ConferenciaDTO conferencia) {
        ConferenciaDTO actualizado = ConferenciaService.update(id, conferencia);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    /**
     * Endpoint para agregar un artículo a una conferencia específica.
     *
     * @param idConferencia Identificador de la conferencia.
     * @param idArticulo Identificador del artículo a agregar.
     * @return Respuesta HTTP con el objeto ConferenciaDTO actualizado y estado OK, o NOT_FOUND si la conferencia no existe.
     */
    @PutMapping("/conferencias/{idConferencia}/articulo")
    public ResponseEntity<ConferenciaDTO> agregarArticulo(@PathVariable Integer idConferencia, @RequestBody Integer idArticulo) {
        ConferenciaDTO actualizado = ConferenciaService.agregarArticulo(idConferencia, idArticulo);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    /**
     * Endpoint para eliminar una conferencia.
     *
     * @param id Identificador de la conferencia a eliminar.
     * @return Respuesta HTTP con true si se eliminó con éxito y estado OK, o false y NOT_FOUND si la conferencia no existe.
     */  
    @DeleteMapping("/conferencias/{id}")
    public ResponseEntity<Boolean> eliminarConferencia(@PathVariable Integer id) {
        ConferenciaDTO ConferenciaActual = ConferenciaService.findById(id);
        if (ConferenciaActual != null) {
            Boolean eliminado = ConferenciaService.delete(id);
            return ResponseEntity.ok(eliminado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }


    @GetMapping("/conferencias/nombre/{nombre}")
	public ConferenciaDTO consultarConferenciaNombre(@PathVariable String nombre) {
		ConferenciaDTO objConferencia = null;
		objConferencia = ConferenciaService.findByNombre(nombre);
		return objConferencia;
	}


    @GetMapping("/conferencias/exist/{id}")
    public Boolean existeConferencia(@PathVariable Integer id) {
        return ConferenciaService.exist(id) != null;
    }

    @GetMapping("/conferencias/cantidadArtc/{id}")
    public int cantidadArticulosDeConferencia(@PathVariable Integer id) {
        return ConferenciaService.cantArticulos(id);
    }
    
}


