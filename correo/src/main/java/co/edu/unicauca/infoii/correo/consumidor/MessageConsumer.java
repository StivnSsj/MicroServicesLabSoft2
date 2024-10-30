package co.edu.unicauca.infoii.correo.consumidor;

import org.springframework.stereotype.Service;

import co.edu.unicauca.infoii.correo.DTOs.ArticuloDTONotificacion;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
public class MessageConsumer {

    @RabbitListener(queues = "temaCorreo")
    public void receiveMessage(ArticuloDTONotificacion objArticuloCreado) {
        System.out.println("Datos del articulo recibidos");
        System.out.println("Enviando correo electrónico");
        System.out.println("Id: "+objArticuloCreado.getId());
        System.out.println("Nombre: "+objArticuloCreado.getTitulo());
        System.out.println("Resumen: "+objArticuloCreado.getResumen());
        System.out.println("Palabras Clave: "+objArticuloCreado.getPalabrasClave());
      
    }
}
    