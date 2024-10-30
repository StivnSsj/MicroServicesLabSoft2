/**
 * Repositorio de usuarios que permite realizar operaciones CRUD sobre una lista
 * de usuarios almacenados en memoria. Simula el comportamiento de un repositorio 
 * persistente al almacenar usuarios en una lista de tipo ArrayList.
 * 
 * Este repositorio es administrado por Spring y utiliza la anotación @Repository.
 */
package co.edu.unicauca.apiusuarios.core.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models.RolEntity;
import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models.UsuarioEntity;

@Repository
public class UsuarioRepository {

    private ArrayList<UsuarioEntity> listaDeUsuarios;
    /**
     * Constructor de UsuarioRepository.
     * Inicializa la lista de usuarios y carga usuarios predeterminados.
     */
    public UsuarioRepository(){
        this.listaDeUsuarios = new ArrayList<UsuarioEntity>();
        cargarUsuarios();
    }
    /**
     * Obtiene todos los usuarios almacenados en el repositorio.
     * 
     * @return Lista de usuarios de tipo UsuarioEntity.
     */
    public List<UsuarioEntity> findAll(){
        System.out.println("Invocando a listarusuarios");
        return this.listaDeUsuarios;
    }
    /**
     * Almacena un nuevo usuario en el repositorio.
     * 
     * @param usuario Objeto UsuarioEntity a almacenar.
     * @return El usuario almacenado, o null si no se pudo agregar.
     */
    public UsuarioEntity save(UsuarioEntity usuario){
        System.out.println("Invocando a almacenar usuario");
        UsuarioEntity objUsuario = null;
        if (this.listaDeUsuarios.add(usuario))
            objUsuario = usuario;
        return objUsuario;
    }
    /**
     * Busca un usuario en el repositorio por su ID.
     * 
     * @param id Identificador único del usuario.
     * @return Objeto UsuarioEntity si se encuentra el usuario, o null si no existe.
     */
    public UsuarioEntity findById(Integer id){
        System.out.println("Invocando a consultar un usuario");
        UsuarioEntity objUsuario = null;

        for (UsuarioEntity usuario : listaDeUsuarios){
            if (usuario.getId() == id){
                objUsuario = usuario;
                break;
            }
        }
        return objUsuario;
    }
    /**
     * Actualiza un usuario existente en el repositorio.
     * 
     * @param id      Identificador del usuario a actualizar.
     * @param usuario Objeto UsuarioEntity con la información actualizada.
     * @return El usuario actualizado, o null si el usuario no se encontró.
     */
    public UsuarioEntity update(Integer id, UsuarioEntity usuario){
        System.out.println("Invocando a actualizar un usuario");
        UsuarioEntity objUsuario = null;

        for (int i = 0; i < this.listaDeUsuarios.size(); i++){
            if (this.listaDeUsuarios.get(i).getId() == id){
                this.listaDeUsuarios.set(i, usuario);
                objUsuario = usuario;
                break;
            }
        }
        return objUsuario;
    }
    /**
     * Elimina un usuario del repositorio por su ID.
     * 
     * @param id Identificador del usuario a eliminar.
     * @return true si el usuario fue eliminado, false si no se encontró.
     */

    public boolean delete(Integer id){
        System.out.println("Invocando a eliminar un usuario");
        boolean bandera = false;

        for (int i = 0; i < listaDeUsuarios.size(); i++){
            if (this.listaDeUsuarios.get(i).getId() == id){
                this.listaDeUsuarios.remove(i);
                bandera = true;
                break;
            }
        }
        return bandera;
    }

    /**
     * Carga una lista de usuarios predeterminados en el repositorio.
     * Este método es llamado durante la inicialización para simular datos iniciales en el sistema.
     */

    private void cargarUsuarios() {
        UsuarioEntity usuario1 = new UsuarioEntity(1, "Juan", "Pérez", "juan.perez@example.com", "contraseña1", new RolEntity(1, "ORGANIZADOR"));
        this.listaDeUsuarios.add(usuario1);

        UsuarioEntity usuario2 = new UsuarioEntity(2, "Ana", "Gómez", "ana.gomez@example.com", "contraseña2", new RolEntity(2, "EVALUADOR"));
        this.listaDeUsuarios.add(usuario2);

        UsuarioEntity usuario3 = new UsuarioEntity(3, "Luis", "Martínez", "luis.martinez@example.com", "contraseña3", new RolEntity(3, "AUTOR"));
        this.listaDeUsuarios.add(usuario3);

        UsuarioEntity usuario5 = new UsuarioEntity(5, "Santiago", "Diaz", "luis.diaz@example.com", "contraseña5", new RolEntity(3, "AUTOR"));
        this.listaDeUsuarios.add(usuario5);

        UsuarioEntity usuario6 = new UsuarioEntity(6, "Juana", "Diaz", "juana.diaz@example.com", "contraseña6", new RolEntity(3, "AUTOR"));
        this.listaDeUsuarios.add(usuario6);

        UsuarioEntity usuario4 = new UsuarioEntity(4, "María", "Hernández", "maria.hernandez@example.com", "contraseña4", new RolEntity(4, "PARTICIPANTE"));
        this.listaDeUsuarios.add(usuario4);       
    }
}