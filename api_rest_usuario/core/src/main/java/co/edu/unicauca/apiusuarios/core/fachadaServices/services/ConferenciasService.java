/**
 * Servicio para gestionar las conferencias asociadas a un usuario.
 * Esta clase utiliza WebClient para realizar una llamada a un servicio externo
 * que devuelve una lista de conferencias a las que un usuario está asociado.
 */
package co.edu.unicauca.apiusuarios.core.fachadaServices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.UsuariosConConferenciasDTO.ConferenciaDTO;
import reactor.core.publisher.Mono;
import java.util.List;

@Service
public class ConferenciasService {
    
    @Autowired
    private WebClient.Builder webClientBuilder;
    /**
     * Obtiene las conferencias asociadas a un usuario dado su ID.
     *
     * @param idUsuario ID del usuario cuyas conferencias se desean obtener.
     * @return Lista de objetos ConferenciaDTO que representan las conferencias
     *         asociadas al usuario. Si no hay conferencias, devuelve una lista vacía.
     */
    public List<ConferenciaDTO> obtenerConferenciasDeUsuario(Integer idUsuario) {
        String url = "http://localhost:1000/api/conferencias/usuario/" + idUsuario;
        // Realiza una solicitud GET al servicio de conferencias y obtiene la respuesta como un array de ConferenciaDTO
        Mono<ConferenciaDTO[]> response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(ConferenciaDTO[].class);
         // Bloquea la ejecución hasta que se obtenga la respuesta y convierte el array en una lista
        ConferenciaDTO[] conferenciasArray = response.block();
        return conferenciasArray != null ? List.of(conferenciasArray) : List.of();
    }
}
