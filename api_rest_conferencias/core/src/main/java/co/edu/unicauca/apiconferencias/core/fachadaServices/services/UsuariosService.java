package co.edu.unicauca.apiconferencias.core.fachadaServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Servicio que se encarga de realizar operaciones relacionadas con los usuarios.
 * Esta clase interactúa con un microservicio de usuarios a través de llamadas HTTP.
 */
@Service
public class UsuariosService {
    
    @Autowired
    private WebClient.Builder webClientBuilder;
     /**
     * Verifica si un usuario tiene un rol específico.
     * Este método realiza una solicitud HTTP a otro microservicio que gestiona usuarios,
     * consultando si un usuario en particular posee un rol determinado.
     *
     * @param idUsuario el ID del usuario a validar.
     * @param rol el nombre del rol a verificar.
     * @return true si el usuario posee el rol especificado; false en caso contrario o si la respuesta es nula.
     */

    public boolean validarRolOrganizador(Integer idUsuario, String rol) {
        String url = "http://localhost:8080/api/usuarios/" + idUsuario + "/validarRol?rol="+rol;

        Boolean tieneRol = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block(); 
                
        return tieneRol != null && tieneRol;
    }
}
