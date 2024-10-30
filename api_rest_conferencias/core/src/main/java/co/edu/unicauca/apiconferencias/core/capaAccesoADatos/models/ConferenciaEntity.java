package co.edu.unicauca.apiconferencias.core.capaAccesoADatos.models;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * Entidad que representa una conferencia en el sistema.
 * Contiene información básica de una conferencia, como nombre, fechas, ubicación y artículos asociados.
 */
@Getter
@Setter
@AllArgsConstructor
public class ConferenciaEntity {
    private Integer id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String ubicacion;
    private List<Integer> articulos;
    /**
     * Constructor por defecto.
     */
    public ConferenciaEntity(){
    
    }
}