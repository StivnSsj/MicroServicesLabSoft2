package co.edu.unicauca.apiarticulos.core.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.apiarticulos.core.capaAccesoADatos.models.RevisionEntity;
/**
 * Repositorio para gestionar los datos de las revisiones.
 * Proporciona métodos para realizar operaciones CRUD en la lista de revisiones,
 * incluyendo la asignación de comentarios y actualización del estado.
 */
@Repository
public class RevisionRepository {
    /**
     * Lista en memoria que simula la base de datos para almacenar revisiones.
     */
    private List<RevisionEntity> listaDeRevisiones;
    /**
     * Constructor que inicializa la lista de revisiones.
     */
    public RevisionRepository() {
        this.listaDeRevisiones = new ArrayList<>();
    }
    /**
     * Obtiene la lista de todas las revisiones.
     * @return Lista de RevisionEntity.
     */
    public List<RevisionEntity> findAll() {
        return this.listaDeRevisiones;
    }
    /**
     * Busca una revisión por su ID.
     * @param idRevision Identificador de la revisión.
     * @return RevisionEntity si es encontrada, de lo contrario null.
     */
    public RevisionEntity findById(Integer idRevision) {
        RevisionEntity objRevision = null;

        for (RevisionEntity revision : listaDeRevisiones) {
            if (revision.getId().equals(idRevision)) {
                objRevision = revision;
                break;
            }
        }
        return objRevision;
    }
    /**
     * Guarda una nueva revisión en la lista.
     * @param revision RevisionEntity a ser guardada.
     * @return La revisión guardada.
     */
    public RevisionEntity save(RevisionEntity revision) {
        this.listaDeRevisiones.add(revision);
        return revision;
    }
    /**
     * Actualiza una revisión existente en la lista.
     * @param id ID de la revisión a actualizar.
     * @param revisionActualizada RevisionEntity con los nuevos datos.
     * @return RevisionEntity actualizada, o null si no se encontró.
     */
    public RevisionEntity update(Integer id, RevisionEntity revisionActualizada) {
        for (int i = 0; i < this.listaDeRevisiones.size(); i++) {
            if (this.listaDeRevisiones.get(i).getId().equals(id)) {
                this.listaDeRevisiones.set(i, revisionActualizada);
                return revisionActualizada;
            }
        }
        return null;
    }
    /**
     * Elimina una revisión de la lista por su ID.
     * @param id Identificador de la revisión a eliminar.
     * @return true si la revisión fue eliminada exitosamente, false si no se encontró.
     */

    public boolean delete(Integer id) {
        return this.listaDeRevisiones.removeIf(revision -> revision.getId().equals(id));
    }
    /**
     * Agrega un comentario a una revisión específica.
     * @param idRevision ID de la revisión a la que se le añadirá el comentario.
     * @param comentario Comentario a añadir.
     * @return La revisión con el comentario agregado o null si no se encontró.
     */

    public RevisionEntity agregarComentario(Integer idRevision, String comentario) {
        RevisionEntity objRevision = null;

        for (int i = 0; i < this.listaDeRevisiones.size(); i++) {
            if (this.listaDeRevisiones.get(i).getId().equals(idRevision)) {
                RevisionEntity revisionObtenida = this.listaDeRevisiones.get(i);
                revisionObtenida.getComentarios().add(comentario);
                this.listaDeRevisiones.set(i, revisionObtenida);
                objRevision = revisionObtenida;
                break;
            }
        }
        return objRevision;
    } 
     /**
     * Actualiza el estado de una revisión específica.
     * @param idRevision ID de la revisión a actualizar.
     * @param estado Nuevo estado de la revisión.
     * @return La revisión con el estado actualizado o null si no se encontró.
     */

    public RevisionEntity actualizarEstado(Integer idRevision, String estado){
        RevisionEntity objRevision = null;

        for (int i = 0; i < this.listaDeRevisiones.size(); i++) {
            if (this.listaDeRevisiones.get(i).getId().equals(idRevision)) {
                RevisionEntity revisionObtenida = this.listaDeRevisiones.get(i);
                revisionObtenida.setEstado(estado);
                this.listaDeRevisiones.set(i, revisionObtenida);
                objRevision = revisionObtenida;
                break;
            }
        }
        return objRevision;
    }
}

