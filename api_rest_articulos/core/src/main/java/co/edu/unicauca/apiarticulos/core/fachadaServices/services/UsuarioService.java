package co.edu.unicauca.apiarticulos.core.fachadaServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
/**
 * Servicio para la gestión de usuarios en el sistema.
 * 
 * La clase `UsuarioService` proporciona métodos para interactuar con el
 * servicio de usuarios, especialmente para la validación de roles de los
 * usuarios a través de una API externa.
 */
@Service
public class UsuarioService {
    
    @Autowired
    private WebClient.Builder webClientBuilder;
    /**
     * Valida si un usuario tiene un rol específico.
     * 
     * @param idUsuario Identificador del usuario cuyo rol se va a validar.
     * @param rol El nombre del rol que se desea validar.
     * @return true si el usuario tiene el rol especificado; false en caso contrario.
     *         Si ocurre un error al consultar, puede devolver false.
     */
    public boolean validarRol(Integer idUsuario, String rol) {
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
