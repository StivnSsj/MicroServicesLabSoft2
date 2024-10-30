package co.edu.unicauca.apiarticulos.core.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.apiarticulos.core.capaAccesoADatos.models.ArticuloEntity;
import co.edu.unicauca.apiarticulos.core.capaAccesoADatos.repositories.ArticuloRepository;
import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.ArticuloDTO;
import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.ArticuloDTONotificacion;
import co.edu.unicauca.apiarticulos.core.rabbit.MessageProducer;
/**
 * Implementación del servicio para la gestión de artículos.
 * 
 * La clase `ArticuloServiceImpl` proporciona la lógica de negocio para manejar las operaciones
 * relacionadas con los artículos, incluyendo la creación, actualización, eliminación y búsqueda de
 * artículos. Utiliza el patrón de diseño de repositorio para acceder a la base de datos y el 
 * patrón DTO (Data Transfer Object) para transferir datos entre la capa de acceso a datos y la capa
 * de presentación.
 */
@Service
public class ArticuloServiceImpl implements IArticuloService {

    @Autowired
    private ArticuloRepository servicioAccesoBaseDatos;

    @Autowired
    private UsuarioService servicioAccesoBaseDatosUsuario;  

    @Autowired
	private ModelMapper modelMapper;

    @Autowired
    private MessageProducer objMessageProducer;
    /**
     * Recupera todos los artículos de la base de datos.
     * 
     * @return Lista de objetos `ArticuloDTO` que representan todos los artículos.
     */
    @Override
	public List<ArticuloDTO> findAll() {

		List<ArticuloEntity> ArticuloEntity = this.servicioAccesoBaseDatos.findAll();
		List<ArticuloDTO> articuloDTO = this.modelMapper.map(ArticuloEntity, new TypeToken<List<ArticuloDTO>>() {
		}.getType());
		return articuloDTO;
	}
     /**
     * Busca un artículo por su identificador.
     * 
     * @param id Identificador del artículo a buscar.
     * @return Objeto `ArticuloDTO` correspondiente al artículo encontrado, o null si no se encuentra.
     */
    @Override
    public ArticuloDTO findById(Integer id) {
        ArticuloEntity objArticuloEntity = this.servicioAccesoBaseDatos.findById(id);
		ArticuloDTO ArticuloDTO = this.modelMapper.map(objArticuloEntity, ArticuloDTO.class);
		return ArticuloDTO;
    }
    /**
     * Verifica si un artículo existe en la base de datos por su identificador.
     * 
     * @param id Identificador del artículo a verificar.
     * @return Objeto `ArticuloDTO` si el artículo existe, o null si no se encuentra.
     */
    @Override
    public ArticuloDTO exist(Integer id) {
        System.out.println("Invocando a consultar un Articulo");
        ArticuloEntity objArticuloEntity = this.servicioAccesoBaseDatos.findById(id);
        if (objArticuloEntity != null) {
            ArticuloDTO articuloDTO = this.modelMapper.map(objArticuloEntity, ArticuloDTO.class);
            return articuloDTO;
        } else {
            System.out.println("El artículo con ID " + id + " no fue encontrado.");
            return null;
        }
    }
    /**
     * Guarda un nuevo artículo en la base de datos.
     * 
     * @param articulo Objeto `ArticuloDTO` que contiene los datos del artículo a crear.
     * @param idUsuario Identificador del usuario que está creando el artículo.
     * @return Objeto `ArticuloDTO` que representa el artículo creado.
     * @throws RuntimeException si el usuario no tiene permisos para subir artículos.
     */
    public ArticuloDTO save(ArticuloDTO articulo, Integer idUsuario) {
        // Validar rol del usuario
        if (!servicioAccesoBaseDatosUsuario.validarRol(idUsuario, "AUTOR")) 
            throw new RuntimeException("El usuario no tiene permisos para subir artículos");

        ArticuloEntity articuloEntity = this.modelMapper.map(articulo, ArticuloEntity.class);
        ArticuloEntity objArticuloEntity = this.servicioAccesoBaseDatos.save(articuloEntity);

        ArticuloDTONotificacion objNotificacion= new ArticuloDTONotificacion();
        objNotificacion.setId(articuloEntity.getId());
        objNotificacion.setTitulo(articuloEntity.getTitulo());
        objNotificacion.setResumen(articuloEntity.getResumen());
        objNotificacion.setPalabrasClave(articuloEntity.getPalabrasClave());
        
        this.objMessageProducer.sendMessage(objNotificacion);
        return this.modelMapper.map(objArticuloEntity, ArticuloDTO.class);
    }
    /**
     * Actualiza un artículo existente en la base de datos.
     * 
     * @param id Identificador del artículo a actualizar.
     * @param articulo Objeto `ArticuloDTO` que contiene los nuevos datos del artículo.
     * @return Objeto `ArticuloDTO` que representa el artículo actualizado.
     */

    @Override
    public ArticuloDTO update(Integer id, ArticuloDTO articulo) {
        ArticuloEntity articuloEntity = this.modelMapper.map(articulo, ArticuloEntity.class);
        ArticuloEntity articuloEntityActualizado = this.servicioAccesoBaseDatos.update(id, articuloEntity);
        ArticuloDTO articuloDTO = this.modelMapper.map(articuloEntityActualizado, ArticuloDTO.class);
        return articuloDTO;
    }
    /**
     * Elimina un artículo de la base de datos.
     * 
     * @param id Identificador del artículo a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }
}
