package co.edu.unicauca.apiarticulos.core.capaAccesoADatos.repositories;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.apiarticulos.core.capaAccesoADatos.models.ArticuloEntity;
import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.ConferenciaDTO;
/**
 * Repositorio para gestionar los datos de los artículos.
 * Proporciona métodos para realizar operaciones CRUD en la lista de artículos,
 * incluyendo la búsqueda, verificación de existencia, adición y eliminación de artículos.
 */
@Repository
public class ArticuloRepository {
    /**
     * Lista en memoria que simula la base de datos para almacenar artículos.
     */
    private ArrayList<ArticuloEntity> listaDeArticulos;
    /**
     * Constructor que inicializa la lista de artículos y carga algunos ejemplos.
     */
    public ArticuloRepository() {
        this.listaDeArticulos = new ArrayList<ArticuloEntity>();
        CargarArticulos();
    }
    /**
     * Obtiene la lista de todos los artículos.
     * @return Lista de ArticuloEntity.
     */
    public List<ArticuloEntity> findAll() {
        System.out.println("Invocando a listarArticulos");
        return this.listaDeArticulos;
    }
    /**
     * Busca un artículo por su ID.
     * @param id Identificador del artículo.
     * @return ArticuloEntity si es encontrado, de lo contrario null.
     */
    public ArticuloEntity findById(Integer id) {
        System.out.println("Invocando a consultar un Articulo");
        ArticuloEntity objArticulo = null;

        for (ArticuloEntity articulo : listaDeArticulos) {
            if (articulo.getId() == id) {
                objArticulo = articulo;
                break;
            }
        }

        return objArticulo;
    }
    /**
     * Verifica si existe un artículo en la lista por su ID.
     * @param id Identificador del artículo.
     * @return true si el artículo existe, false en caso contrario.
     */
    public boolean existeArticulo(Integer id) {
        for (ArticuloEntity articulo : listaDeArticulos) {
            if (articulo.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
   
    public ArticuloEntity exist(Integer id) {
        System.out.println("Invocando a consultar un Articulo");

        ArticuloEntity objArticulo = null;

        if (existeArticulo(id)) {
            for (ArticuloEntity articulo : listaDeArticulos) {
                if (articulo.getId().equals(id)) {
                    objArticulo = articulo;
                    break;
                }
            }
        } else {
            System.out.println("El artículo con ID " + id + " no fue encontrado.");
        }

        return objArticulo;
    }
    /**
     * Guarda un nuevo artículo en la lista.
     * @param articulo ArticuloEntity a ser guardado.
     * @return El artículo guardado si se agrega exitosamente, de lo contrario null.
     */
    public ArticuloEntity save(ArticuloEntity articulo) {
        System.out.println("Invocando a almacenar un articulo");
        ArticuloEntity objArticulo = null;
        if (this.listaDeArticulos.add(articulo)) {
            objArticulo = articulo;
        }

        return objArticulo;
    }
    /**
     * Actualiza un artículo existente en la lista.
     * @param id ID del artículo a actualizar.
     * @param articulo ArticuloEntity con los nuevos datos.
     * @return ArticuloEntity actualizado, o null si no se encontró el artículo.
     */

    public ArticuloEntity update(Integer id, ArticuloEntity articulo) {
        System.out.println("Invocando a actualizar un articulo");
        ArticuloEntity objArticulo = null;

        for (int i = 0; i < this.listaDeArticulos.size(); i++) {
            if (this.listaDeArticulos.get(i).getId() == id) {
                this.listaDeArticulos.set(i, articulo);
                objArticulo = articulo;
                break;
            }
        }

        return objArticulo;
    }
    /**
     * Elimina un artículo de la lista por su ID.
     * @param id Identificador del artículo a eliminar.
     * @return true si el artículo fue eliminado exitosamente, false si no se encontró.
     */
    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar un articulo");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeArticulos.size(); i++) {
            if (this.listaDeArticulos.get(i).getId() == id) {
                this.listaDeArticulos.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    /**
     * Método privado que carga algunos artículos de ejemplo.
     */
    private void CargarArticulos() {
        ArrayList<Integer> listaAutores1 = new ArrayList<>();
        listaAutores1.add(3);
        

        ArticuloEntity objArticulo1 = new ArticuloEntity(1, "IA en la actualidad", "Resumen del artículo sobre IA", "IA, Tecnología, Futuro", listaAutores1, new ConferenciaDTO(1));
        this.listaDeArticulos.add(objArticulo1);

        ArrayList<Integer> listaAutores2 = new ArrayList<>();
        listaAutores2.add(5);
        ArticuloEntity objArticulo2 = new ArticuloEntity(2, "Ingeniería de software", "Resumen del artículo sobre ingeniería de software", "Software, Ingeniería, Desarrollo", listaAutores2, new ConferenciaDTO(2));
        this.listaDeArticulos.add(objArticulo2);

        ArrayList<Integer> listaAutores3 = new ArrayList<>();
        listaAutores3.add(6);
        listaAutores3.add(3);
        ArticuloEntity objArticulo3 = new ArticuloEntity(3, "Tecnología", "Resumen del artículo sobre tecnología", "Tecnología, Innovación", listaAutores3, new ConferenciaDTO(3));
        this.listaDeArticulos.add(objArticulo3);
    }

}
