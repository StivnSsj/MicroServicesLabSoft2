package co.edu.unicauca.apiarticulos.core.fachadaServices.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticuloDTONotificacion {
    
    private Integer id;
    
    private String titulo;
    
    private String resumen;
   
    private String palabrasClave;
  
    public ArticuloDTONotificacion() {
        
    } 
}
