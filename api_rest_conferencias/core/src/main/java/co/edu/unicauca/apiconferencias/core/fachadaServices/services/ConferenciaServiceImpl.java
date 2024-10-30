package co.edu.unicauca.apiconferencias.core.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.apiconferencias.core.capaAccesoADatos.models.ConferenciaEntity;
import co.edu.unicauca.apiconferencias.core.capaAccesoADatos.repositories.ConferenciaRepository;
import co.edu.unicauca.apiconferencias.core.fachadaServices.DTO.ConferenciaDTO;
/**
 * Implementación de la interfaz IConferenciaService.
 * Proporciona métodos para la gestión de conferencias, incluyendo las operaciones CRUD
 * y la agregación de artículos a una conferencia específica.
 */
@Service
public class ConferenciaServiceImpl implements IConferenciaService{

    @Autowired
    private ConferenciaRepository servicioAccesoBaseDatos;

    @Autowired
    private UsuariosService servicioAccesoBaseDatosUsuario;

    @Autowired
	private ModelMapper modelMapper;
    /**
     * Obtiene la lista completa de conferencias.
     * Convierte las entidades de conferencias a DTOs antes de retornarlas.
     *
     * @return Lista de ConferenciaDTO que representa todas las conferencias en la base de datos.
     */
    @Override
	public List<ConferenciaDTO> findAll() {
		List<ConferenciaEntity> ConferenciaEntity = this.servicioAccesoBaseDatos.findAll();
		List<ConferenciaDTO> conferenciaDTO = this.modelMapper.map(ConferenciaEntity, new TypeToken<List<ConferenciaDTO>>() {
		}.getType());
		return conferenciaDTO;
	}
    /**
     * Busca una conferencia específica por su ID.
     * Convierte la entidad de conferencia a un DTO antes de retornarlo.
     *
     * @param id ID de la conferencia a buscar.
     * @return ConferenciaDTO correspondiente a la conferencia encontrada, o null si no existe.
     */
    @Override
    public ConferenciaDTO findById(Integer id) {
        ConferenciaEntity objConferenciaEntity = this.servicioAccesoBaseDatos.findById(id);
		ConferenciaDTO conferenciaDTO = this.modelMapper.map(objConferenciaEntity, ConferenciaDTO.class);
		return conferenciaDTO;
    }
    
    /**
     * Guarda una nueva conferencia en la base de datos.
     * Verifica si el usuario tiene permisos de "ORGANIZADOR" antes de realizar la operación.
     *
     * @param conferencia DTO de la conferencia a guardar.
     * @param idUsuario ID del usuario que intenta realizar la operación.
     * @return ConferenciaDTO correspondiente a la conferencia guardada.
     * @throws RuntimeException si el usuario no tiene permisos de organizador.
     */
    @Override
    public ConferenciaDTO save(ConferenciaDTO conferencia, Integer idUsuario) {
        // Validar rol del usuario
        if (!servicioAccesoBaseDatosUsuario.validarRolOrganizador(idUsuario, "ORGANIZADOR")) {
            throw new RuntimeException("El usuario no tiene permisos para crear conferencias");
        }
        ConferenciaEntity conferenciaEntity = this.modelMapper.map(conferencia, ConferenciaEntity.class);
		ConferenciaEntity objConferenciaEntity = this.servicioAccesoBaseDatos.save(conferenciaEntity);
		ConferenciaDTO conferenciaDTO = this.modelMapper.map(objConferenciaEntity, ConferenciaDTO.class);
		return conferenciaDTO;
    }

    /**
     * Actualiza una conferencia existente.
     * Convierte el DTO a entidad antes de actualizar y devuelve el DTO actualizado.
     *
     * @param id ID de la conferencia a actualizar.
     * @param conferencia DTO de la conferencia con los datos actualizados.
     * @return ConferenciaDTO correspondiente a la conferencia actualizada.
     */
    @Override
    public ConferenciaDTO update(Integer id, ConferenciaDTO conferencia) {
        ConferenciaEntity ConferenciaEntity = this.modelMapper.map(conferencia, ConferenciaEntity.class);
        ConferenciaEntity ConferenciaEntityActualizado = this.servicioAccesoBaseDatos.update(id, ConferenciaEntity);
        ConferenciaDTO ConferenciaDTO = this.modelMapper.map(ConferenciaEntityActualizado, ConferenciaDTO.class);
        return ConferenciaDTO;
    }
    /**
     * Elimina una conferencia de la base de datos.
     *
     * @param id ID de la conferencia a eliminar.
     * @return true si la conferencia fue eliminada exitosamente, false en caso contrario.
     */
    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }
    /**
     * Agrega un artículo a una conferencia específica.
     *
     * @param idConferencia ID de la conferencia a la que se desea agregar el artículo.
     * @param idArticulo ID del artículo que se desea agregar.
     * @return ConferenciaDTO correspondiente a la conferencia con el artículo agregado.
     */
    @Override
    public ConferenciaDTO agregarArticulo(Integer idConferencia, Integer idArticulo) {
        ConferenciaEntity conferenciaConArticuloAgregado = this.servicioAccesoBaseDatos.agregarArticulo(idConferencia, idArticulo);
        ConferenciaDTO ConferenciaDTO = this.modelMapper.map(conferenciaConArticuloAgregado, ConferenciaDTO.class);
        return ConferenciaDTO; 
    }
    @Override
    public ConferenciaDTO findByNombre(String nombre) {
        ConferenciaEntity objConferenciaEntity = this.servicioAccesoBaseDatos.findByNombre(nombre);
		ConferenciaDTO conferenciaDTO = this.modelMapper.map(objConferenciaEntity, ConferenciaDTO.class);
		return conferenciaDTO;
    }
    @Override
    public ConferenciaDTO exist(Integer id) {
        System.out.println("Invocando a consultar una Conferencia");
        ConferenciaEntity objConferenciaEntity = this.servicioAccesoBaseDatos.findById(id);
        if (objConferenciaEntity != null) {
            ConferenciaDTO conferenciaDTO = this.modelMapper.map(objConferenciaEntity, ConferenciaDTO.class);
            return conferenciaDTO;
        } else {
            System.out.println("La conferencia con ID " + id + " no fue encontrada.");
            return null;
        }
    }
    @Override
    public int cantArticulos(Integer id) {
        return this.servicioAccesoBaseDatos.CountArticulos(id);
    }
    
}
