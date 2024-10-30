package co.edu.unicauca.apiarticulos.core.rabbit;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;


import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.ArticuloDTONotificacion;

@Service
public class MessageProducer {
    private final AmqpTemplate amqpTemplate;
    private final String exchange = "myExchange";
    private final String routingKey = "routingKey";

    public MessageProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMessage(ArticuloDTONotificacion objArticuloCreado) {
        amqpTemplate.convertAndSend(exchange, routingKey, objArticuloCreado);
        System.out.println("Datos del articulo enviado a la cola");
    }
}
