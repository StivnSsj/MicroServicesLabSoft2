package co.edu.unicauca.apiarticulos.core.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.ArticuloDTO;
import co.edu.unicauca.apiarticulos.core.fachadaServices.services.IArticuloService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping ("/api")

public class ArticuloRestController {
    @Autowired
	private IArticuloService ArticuloService;
    /**
     * Endpoint inicial de la API.
     * @return Mensaje de bienvenida.
     */

	@GetMapping("/")
    public String home() {
        return "Bienvenido a la API de Artículos!";
    }
     /**
     * Lista todos los artículos disponibles.
     * @return Lista de `ArticuloDTO` que representa todos los artículos.
     */
	
    @GetMapping("/articulos")
    public List<ArticuloDTO> listarArticulos() {
		return ArticuloService.findAll();
    }
    /**
     * Busca un artículo por ID.
     * @param id Identificador único del artículo.
     * @return El `ArticuloDTO` correspondiente al ID o `null` si no existe.
     */

    @GetMapping("/articulos/{id}")
	public ArticuloDTO consultarArticulo(@PathVariable Integer id) {
		ArticuloDTO objArticulo = null;
		objArticulo = ArticuloService.findById(id);
		return objArticulo;
	}
    /**
     * Crea un nuevo artículo.
     * @param articulo Objeto `ArticuloDTO` con la información del artículo.
     * @param idUsuario ID del usuario que crea el artículo.
     * @return El artículo creado como `ArticuloDTO`.
     */
    @PostMapping("/articulos")
	public ArticuloDTO crearArticulo(@RequestBody ArticuloDTO articulo, @RequestParam Integer idUsuario) {
		ArticuloDTO objArticulo = null;
		objArticulo = ArticuloService.save(articulo, idUsuario);
		return objArticulo;
	}
     /**
     * Actualiza la información de un artículo existente.
     * @param id Identificador único del artículo.
     * @param articulo Objeto `ArticuloDTO` con la nueva información.
     * @return `ResponseEntity` con el artículo actualizado o `NOT_FOUND` si el artículo no existe.
     */
    @PutMapping("/articulos/{id}")
    public ResponseEntity<ArticuloDTO> actualizarArticulo(@PathVariable Integer id, @RequestBody ArticuloDTO articulo) {
        ArticuloDTO actualizado = ArticuloService.update(id, articulo);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    /**
     * Elimina un artículo por ID.
     * @param id Identificador único del artículo.
     * @return `ResponseEntity` con `true` si el artículo se eliminó, `false` si no existe.
     */
    
    @DeleteMapping("/articulos/{id}")
    public ResponseEntity<Boolean> eliminarArticulo(@PathVariable Integer id) {
        ArticuloDTO articuloActual = ArticuloService.findById(id);
        if (articuloActual != null) {
            Boolean eliminado = ArticuloService.delete(id);
            return ResponseEntity.ok(eliminado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
    /**
     * Verifica si un artículo existe por ID.
     * @param id Identificador único del artículo.
     * @return `true` si el artículo existe, `false` si no.
     */
    @GetMapping("/articulos/exist/{id}")
    public Boolean existeArticulo(@PathVariable Integer id) {
        return ArticuloService.exist(id) != null;
    }
}
