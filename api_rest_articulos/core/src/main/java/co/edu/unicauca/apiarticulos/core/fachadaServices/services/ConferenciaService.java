package co.edu.unicauca.apiarticulos.core.fachadaServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.UsuarioDTO;
/**
 * Servicio para gestionar operaciones relacionadas con conferencias.
 * 
 * La clase `ConferenciaService` proporciona métodos para validar roles de usuario mediante
 * comunicación con un servicio externo a través de `WebClient`. Esta clase permite verificar si
 * un usuario tiene un rol específico necesario para realizar acciones en el contexto de conferencias.
 */
@Service
public class ConferenciaService {
    @Autowired
    private WebClient.Builder webClientBuilder;
    /**
     * Valida si un usuario tiene un rol específico.
     * 
     * Este método realiza una solicitud GET a un servicio externo para recuperar la información
     * del usuario por su identificador y verifica si el rol del usuario coincide con el rol esperado.
     * 
     * @param idUsuario Identificador del usuario cuya información se va a validar.
     * @param rol Nombre del rol que se desea validar.
     * @return true si el usuario tiene el rol especificado, false en caso contrario.
     */

    public boolean validarRol(Integer idUsuario, String rol) {
        String url = "http://localhost:8080/api/usuarios/" + idUsuario;

        UsuarioDTO usuarioDTO = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(UsuarioDTO.class)
                .block();

        return usuarioDTO != null && usuarioDTO.getRol().getNombre().equals(rol);
    }
}
