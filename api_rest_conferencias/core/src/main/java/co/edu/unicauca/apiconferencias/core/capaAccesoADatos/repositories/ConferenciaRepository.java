package co.edu.unicauca.apiconferencias.core.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.apiconferencias.core.capaAccesoADatos.models.ConferenciaEntity;
/**
 * Repositorio para el manejo de las conferencias en memoria.
 * Permite realizar operaciones CRUD sobre conferencias.
 */
@Repository
public class ConferenciaRepository {
    private ArrayList<ConferenciaEntity> listaDeConferencias;
	/**
     * Constructor que inicializa la lista de conferencias y carga datos de ejemplo.
     */
	public ConferenciaRepository() {
		this.listaDeConferencias = new ArrayList<ConferenciaEntity>();
		cargarConferencias();
	}
	/**
     * Obtiene la lista completa de conferencias.
     *
     * @return Lista de objetos ConferenciaEntity que representan las conferencias disponibles.
     */
    public List<ConferenciaEntity> findAll() {
		System.out.println("Invocando a listarConferencias");
		return this.listaDeConferencias;
	}
	/**
     * Busca una conferencia por su ID.
     *
     * @param id Identificador de la conferencia a buscar.
     * @return Objeto ConferenciaEntity que representa la conferencia encontrada, o null si no se encuentra.
     */
	public ConferenciaEntity findById(Integer id) {
        System.out.println("Invocando a consultar una conferencia");
        ConferenciaEntity objConferencia = null;

        for (ConferenciaEntity conferencia : listaDeConferencias) {
            if (conferencia.getId() == id) {
                objConferencia = conferencia;
                break;
            }
        }
        return objConferencia;
    }

	public ConferenciaEntity findByNombre(String nombre) {
		System.out.println("Invocando a consultar una conferencia por nombre");
		ConferenciaEntity objConferencia = null;
	
		for (ConferenciaEntity conferencia : listaDeConferencias) {
			// Cambia la comparación para usar el nombre de la conferencia
			if (conferencia.getNombre().equalsIgnoreCase(nombre)) {
				objConferencia = conferencia;
				break;
			}
		}
		return objConferencia;
	}
	
	/**
     * Guarda una nueva conferencia en la lista.
     *
     * @param conferencia Objeto ConferenciaEntity a almacenar.
     * @return ConferenciaEntity que representa la conferencia guardada.
     */
	public ConferenciaEntity save(ConferenciaEntity conferencia) {
		System.out.println("Invocando a almacenar una conferencia");
		ConferenciaEntity objConferencia = null;
		if (this.listaDeConferencias.add(conferencia))
			objConferencia = conferencia;
		return objConferencia;
	}
	/**
     * Actualiza una conferencia existente en la lista.
     *
     * @param id Identificador de la conferencia a actualizar.
     * @param conferencia Objeto ConferenciaEntity con los datos actualizados.
     * @return ConferenciaEntity que representa la conferencia actualizada, o null si no se encuentra.
     */

	public ConferenciaEntity update(Integer id, ConferenciaEntity conferencia) {
		System.out.println("Invocando a actualizar una conferencia");
		ConferenciaEntity objConferencias = null;

		for (int i = 0; i < this.listaDeConferencias.size(); i++) {
			if (this.listaDeConferencias.get(i).getId() == id) {
				this.listaDeConferencias.set(i, conferencia);
				objConferencias = conferencia;
				break;
			}
		}
		return objConferencias;
	}
	/**
     * Agrega un artículo a la lista de artículos de una conferencia.
     *
     * @param id Identificador de la conferencia.
     * @param idArticulo Identificador del artículo a agregar.
     * @return ConferenciaEntity que representa la conferencia actualizada, o null si no se encuentra.
     */

	public ConferenciaEntity agregarArticulo(Integer id, Integer idArticulo) {
		System.out.println("Invocando a agregar un articulo");
		ConferenciaEntity objConferencia = null;

		for (int i = 0; i < this.listaDeConferencias.size(); i++) {
			if (this.listaDeConferencias.get(i).getId().equals(id)) {
				ConferenciaEntity conferenciaObtenida = this.listaDeConferencias.get(i);

				if (!conferenciaObtenida.getArticulos().contains(idArticulo)) {
                    conferenciaObtenida.getArticulos().add(idArticulo);
                }

				this.listaDeConferencias.set(i, conferenciaObtenida);
				objConferencia = conferenciaObtenida;
				break;
			}
		}
		return objConferencia;
	}
	/**
     * Elimina una conferencia de la lista por su ID.
     *
     * @param id Identificador de la conferencia a eliminar.
     * @return true si la conferencia se eliminó con éxito, false en caso contrario.
     */
	public boolean delete(Integer id) {
		System.out.println("Invocando a eliminar una conferencia");
		boolean bandera = false;

		for (int i = 0; i < this.listaDeConferencias.size(); i++) {
			if (this.listaDeConferencias.get(i).getId() == id) {
				this.listaDeConferencias.remove(i);
				bandera = true;
				break;
			}
		}
		return bandera;
	}

	public int CountArticulos(Integer id){
		int count = 0;
		for (int i = 0; i < this.listaDeConferencias.size(); i++) {
			if (this.listaDeConferencias.get(i).getId() == id) {
				count = this.listaDeConferencias.get(i).getArticulos().size();
			}
		}
		return count;
	}
	/**
     * Carga datos de ejemplo de conferencias en la lista.
     * Método privado para inicializar la lista con algunos datos.
     */

	private void cargarConferencias() {
		List<Integer> listArt = new ArrayList<>();
		listArt.add(1);
		listArt.add(2);

		ConferenciaEntity objConferencias1 = new ConferenciaEntity(1, "IA", LocalDate.of(2024, 10, 20), LocalDate.of(2024, 10, 22), "Auditorio A", listArt);
        listaDeConferencias.add(objConferencias1);

        ConferenciaEntity objConferencias2 = new ConferenciaEntity(2, "Desarrollo Sostenible", LocalDate.of(2024, 11, 5), LocalDate.of(2024, 11, 7), "Salón B", new ArrayList<Integer>());
        listaDeConferencias.add(objConferencias2);

        ConferenciaEntity objConferencias3 = new ConferenciaEntity(3, "Innovación Tecnológica", LocalDate.of(2024, 11, 15), LocalDate.of(2024, 11, 17), "Sala C", new ArrayList<Integer>());
        listaDeConferencias.add(objConferencias3);

        ConferenciaEntity objConferencias4 = new ConferenciaEntity(4, "Educación en la Era Digital", LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 3), "Sala D", new ArrayList<Integer>());
        listaDeConferencias.add(objConferencias4);
	}
}
