package com.ecbackend.eClubTest.Config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.colaCompra.nombre}")
    private String nombreColaCompra;
    @Value("${rabbitmq.eClub_exchange}")
    private String nombreExchange;
    @Value("${rabbitmq.colaCompra.RoutingKey}")
    private String routingKeyCompra;

    @Value("${rabbitmq.colaVenta.nombre}")
    private String nombreColaVenta;

    @Value("${rabbitmq.colaVenta.RoutingKey}")
    private String routingKeyVenta;

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(nombreExchange);
    }

    @Bean
    public Queue colaCompra(){
        return new Queue(nombreColaCompra);
    }


    @Bean
    public Queue colaVenta(){
        return new Queue(nombreColaVenta);
    }

    // Vincula la la cola de compra al exchange mediante routingKeyCompra
    @Bean
    public Binding compraBinding(){
        return BindingBuilder
                .bind(colaCompra())
                .to(exchange())
                .with(routingKeyCompra);
    }

    // De la misma manera se vincula la cola de venta al exchange mediante routingKeyVenta
    @Bean
    public Binding ventaBinding(){
        return BindingBuilder
                .bind(colaVenta())
                .to(exchange())
                .with(routingKeyVenta);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
