/**
 * Data Transfer Object (DTO) para representar un usuario junto con sus conferencias asociadas.
 * Contiene un objeto UsuarioDTO y una lista de ConferenciaDTOs que representan las conferencias 
 * en las que el usuario participa o está asociado.
 */
package co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.UsuariosConConferenciasDTO;

import java.util.List;

import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.CRUDUsuariosDTO.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class UsuarioConConferenciasDTO {
    private UsuarioDTO objCUsuarioDTO; // Objeto que representa el usuario asociado
    private List<ConferenciaDTO> conferencias; // Lista de conferencias asociadas al usuario
}
