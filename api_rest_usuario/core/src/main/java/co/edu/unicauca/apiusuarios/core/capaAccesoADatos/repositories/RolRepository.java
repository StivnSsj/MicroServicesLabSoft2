/**
 * Repositorio de roles que permite realizar operaciones CRUD sobre una lista
 * de roles almacenados en memoria. Simula el comportamiento de un repositorio 
 * persistente al almacenar roles en una lista de tipo ArrayList.
 * 
 * Este repositorio es administrado por Spring y utiliza la anotación @Repository.
 */
package co.edu.unicauca.apiusuarios.core.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models.RolEntity;

@Repository
public class RolRepository {
    
    private ArrayList<RolEntity> listaRoles;
    /**
     * Constructor de RolRepository.
     * Inicializa la lista de roles y carga roles predeterminados.
     */
    
    public RolRepository(){
        this.listaRoles = new ArrayList<RolEntity>();
        cargarRoles();
    }
    /**
     * Obtiene todos los roles almacenados en el repositorio.
     * 
     * @return Lista de roles de tipo RolEntity.
     */

    public List<RolEntity> findAll(){
        System.out.println("Invocando a listarroles");
        return this.listaRoles;
    }
    /**
     * Almacena un nuevo rol en el repositorio.
     * 
     * @param rol Objeto RolEntity a almacenar.
     * @return El rol almacenado, o null si no se pudo agregar.
     */
    public RolEntity save(RolEntity rol){
        System.out.println("Invocando a almacenar rol");
        RolEntity objRol = null;
        if (this.listaRoles.add(rol))
            objRol = rol;
        return objRol;
    }
    /**
     * Busca un rol en el repositorio por su ID.
     * 
     * @param id Identificador único del rol.
     * @return Objeto RolEntity si se encuentra el rol, o null si no existe.
     */

    public RolEntity findById(Integer id){
        System.out.println("Invocando a consultar un rol");
        RolEntity objRol = null;

        for(RolEntity rol : listaRoles){
            if(rol.getId() == id){
                objRol = rol;
                break;
            }
        }
        return objRol;
    }
     /**
     * Actualiza un rol existente en el repositorio.
     * 
     * @param id  Identificador del rol a actualizar.
     * @param rol Objeto RolEntity con la información actualizada.
     * @return El rol actualizado, o null si el rol no se encontró.
     */

    public RolEntity update(Integer id, RolEntity rol){
        System.out.println("Invocando a actualizar un rol");
        RolEntity objRol = null;
        for (int i = 0; i < this.listaRoles.size(); i++){
            if (this.listaRoles.get(i).getId() == id){
                this.listaRoles.set(i, rol);
                objRol = rol;
                break;
            }
        }
        return objRol;
    }
    /**
     * Elimina un rol del repositorio por su ID.
     * 
     * @param id Identificador del rol a eliminar.
     * @return true si el rol fue eliminado, false si no se encontró.
     */
    public boolean delete(Integer id){
        System.out.println("Invocando a eliminar un rol");
        boolean bandera = false;
        for (int i = 0; i < this.listaRoles.size(); i++){
            if (this.listaRoles.get(i).getId() == id){
                this.listaRoles.remove(i);
                bandera = true;
                break;
            }
        }
        return bandera;
    }

    /**
     * Carga una lista de roles predeterminados en el repositorio. Este método es
     * llamado durante la inicialización para simular datos iniciales en el sistema.
     */

    private void cargarRoles() {
        RolEntity objRol1 = new RolEntity(1, "ORGANIZADOR");
        this.listaRoles.add(objRol1);
        RolEntity objRol2 = new RolEntity(2, "EVALUADOR");
        this.listaRoles.add(objRol2);
        RolEntity objRol3 = new RolEntity(3, "AUTOR");
        this.listaRoles.add(objRol3);
        RolEntity objRol4 = new RolEntity(4, "PARTICIPANTE");
        this.listaRoles.add(objRol4);
    }
}
