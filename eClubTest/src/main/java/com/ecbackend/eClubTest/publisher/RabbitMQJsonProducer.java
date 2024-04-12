package com.ecbackend.eClubTest.publisher;

import com.ecbackend.eClubTest.Dto.TransaccionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.eClub_exchange}")
    private String exchange;

    @Value("${rabbitmq.colaCompra.RoutingKey}")
    private String routingKeyCompra;

    @Value("${rabbitmq.colaVenta.RoutingKey}")
    private String routingKeyVenta;



    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    // inyeccion de dependencia
    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendCompra(TransaccionDto compra){
        LOGGER.info(String.format("Mensaje enviado -> %s", compra.toString()));
        rabbitTemplate.convertAndSend(exchange,routingKeyCompra, compra);

    }

    public void sendVenta(TransaccionDto venta){
        LOGGER.info(String.format("Mensaje enviado -> %s", venta.toString()));
        rabbitTemplate.convertAndSend(exchange,routingKeyVenta, venta);

    }
}
