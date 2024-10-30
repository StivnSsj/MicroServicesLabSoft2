package co.edu.unicauca.apiarticulos.core.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.apiarticulos.core.capaAccesoADatos.models.RevisionEntity;
import co.edu.unicauca.apiarticulos.core.capaAccesoADatos.repositories.RevisionRepository;
import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.RevisionDTO;
/**
 * Implementación del servicio para la gestión de revisiones de artículos.
 * 
 * La clase `RevisionServiceImpl` proporciona la lógica de negocio para la
 * manipulación de las revisiones de artículos, implementando la interfaz
 * `IRevisionService`. Utiliza un repositorio para acceder a los datos
 * de las revisiones y un `ModelMapper` para convertir entre entidades y DTOs.
 */
@Service
public class RevisionServiceImpl implements IRevisionService{
    
    @Autowired
    private RevisionRepository servicioAccesoBaseDatos;

    @Autowired
    private UsuarioService servicioAccesoBaseDatosUsuario;

    @Autowired
    private ModelMapper modelMapper;
    /**
     * Obtiene todas las revisiones.
     * 
     * @return Lista de objetos `RevisionDTO` que representan todas las revisiones.
     */
    @Override
	public List<RevisionDTO> findAll() {
		List<RevisionEntity> RevisionEntity = this.servicioAccesoBaseDatos.findAll();
		List<RevisionDTO> RevisionDTO = this.modelMapper.map(RevisionEntity, new TypeToken<List<RevisionDTO>>() {
		}.getType());
		return RevisionDTO;
	}
    /**
     * Busca una revisión por su identificador.
     * 
     * @param idRevision Identificador de la revisión a buscar.
     * @return El objeto `RevisionDTO` correspondiente a la revisión encontrada, o null si no se encuentra.
     */
    @Override
    public RevisionDTO findById(Integer idRevision) {
        RevisionEntity objRevisionEntity = this.servicioAccesoBaseDatos.findById(idRevision);
        RevisionDTO revisionDTO = this.modelMapper.map(objRevisionEntity, RevisionDTO.class);
        return revisionDTO;
    }
    /**
     * Guarda una nueva revisión en el sistema.
     * 
     * @param revision Objeto `RevisionDTO` que contiene la información de la revisión a guardar.
     * @param idUsuario Identificador del usuario que está creando la revisión.
     * @return El objeto `RevisionDTO` que representa la revisión guardada, incluyendo su identificador.
     * @throws RuntimeException Si el usuario no tiene el rol adecuado para crear revisiones.
     */
    @Override
    public RevisionDTO save(RevisionDTO revision, Integer idUsuario) {
        // Validar rol del usuario
        if (!servicioAccesoBaseDatosUsuario.validarRol(idUsuario, "ORGANIZADOR"))
            throw new RuntimeException("El usuario no tiene permisos para crear una revision");

        for (Integer idEvaluador : revision.getEvaluadores()) {
            if (!servicioAccesoBaseDatosUsuario.validarRol(idUsuario, "EVALUADOR"))
                throw new RuntimeException("El evaluador con ID " + idEvaluador + 
                                                " no puede ser asignado ya que no es un EVALUADOR"); 
        }

        RevisionEntity RevisionEntity = this.modelMapper.map(revision, RevisionEntity.class);
		RevisionEntity objRevisionEntity = this.servicioAccesoBaseDatos.save(RevisionEntity);
		RevisionDTO RevisionDTO = this.modelMapper.map(objRevisionEntity, RevisionDTO.class);
		return RevisionDTO;
    }
    /**
     * Actualiza la información de una revisión existente.
     * 
     * @param id Identificador de la revisión a actualizar.
     * @param revision Objeto `RevisionDTO` que contiene la nueva información de la revisión.
     * @return El objeto `RevisionDTO` que representa la revisión actualizada.
     */

    @Override
    public RevisionDTO update(Integer id, RevisionDTO revision) {
        RevisionEntity RevisionEntity = this.modelMapper.map(revision, RevisionEntity.class);
        RevisionEntity revisionEntityActualizado = this.servicioAccesoBaseDatos.update(id, RevisionEntity);
        RevisionDTO RevisionDTO = this.modelMapper.map(revisionEntityActualizado, RevisionDTO.class);
        return RevisionDTO;
    }
    /**
     * Elimina una revisión del sistema.
     * 
     * @param id Identificador de la revisión a eliminar.
     * @return true si la revisión fue eliminada exitosamente, false en caso contrario.
     */
    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }
    /**
     * Agrega un comentario a una revisión existente.
     * 
     * @param idRevision Identificador de la revisión a la que se agregará el comentario.
     * @param idEvaluador Identificador del evaluador que hace el comentario.
     * @param comentario El texto del comentario a agregar.
     * @return El objeto `RevisionDTO` que representa la revisión actualizada con el nuevo comentario.
     * @throws RuntimeException Si el usuario no tiene el rol adecuado para agregar comentarios.
     */
    @Override
    public RevisionDTO agregarComentario(Integer idRevision, Integer idEvaluador, String comentario) {
        // Validar rol del usuario
        if (!servicioAccesoBaseDatosUsuario.validarRol(idEvaluador, "EVALUADOR"))
            throw new RuntimeException("El usuario no tiene permisos para evaluar el articulo");

        RevisionEntity revisionConComentario = this.servicioAccesoBaseDatos.agregarComentario(idRevision, comentario);
        RevisionDTO RevisionDTO = this.modelMapper.map(revisionConComentario, RevisionDTO.class);
        return RevisionDTO;
    }
    /**
     * Actualiza el estado de una revisión existente.
     * 
     * @param idRevision Identificador de la revisión cuyo estado se actualizará.
     * @param estado Nuevo estado a establecer para la revisión.
     * @return El objeto `RevisionDTO` que representa la revisión actualizada con el nuevo estado.
     */
    @Override
    public RevisionDTO actualizarEstado(Integer idRevision, String estado) {
        RevisionEntity revisionActulizada = this.servicioAccesoBaseDatos.actualizarEstado(idRevision, estado);
        RevisionDTO revisionDTO = this.modelMapper.map(revisionActulizada, RevisionDTO.class);
        return revisionDTO;
    }
}
