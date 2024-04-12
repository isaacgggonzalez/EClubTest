package com.ecbackend.eClubTest.Consumer;

import com.ecbackend.eClubTest.Dto.TransaccionDto;
import com.ecbackend.eClubTest.Entity.Transaccion;
import com.ecbackend.eClubTest.Mapper.TransaccionMapper;
import com.ecbackend.eClubTest.Services.ClienteService;
import com.ecbackend.eClubTest.Services.ProductoService;
import com.ecbackend.eClubTest.exception.ProductoInsuficienteException;
import com.ecbackend.eClubTest.exception.ResourceNotFoundException;
import com.ecbackend.eClubTest.repository.TransaccionRepositorio;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class RabbitMQConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);
    ProductoService productoService;
    TransaccionRepositorio transaccionRepositorio;
    ClienteService clienteService;


    @RabbitListener(queues = "${rabbitmq.colaCompra.nombre}")
    public void consumerCompra(TransaccionDto compra){
        Transaccion transaccion = TransaccionMapper.TransaccionDtoToCompra(compra);
        LOGGER.info(String.format("Mensaje recibido -> %s", compra.toString()));
        try {
            clienteService.obtenerCliente(transaccion.getIdCLienteProveedor());
            productoService.comprarProducto(transaccion.getIdProducto(), transaccion.getCantidad());
            transaccionRepositorio.save(transaccion);
            LOGGER.info("Compra realizada correctamente");

        } catch (ResourceNotFoundException e) {
            LOGGER.error("No se encontró el producto o cliente");
        }
    }

    @RabbitListener(queues = "${rabbitmq.colaVenta.nombre}")
    public void consumerVenta(TransaccionDto compra){
        Transaccion transaccion = TransaccionMapper.TransaccionDtoToVenta(compra);
        LOGGER.info(String.format("Mensaje recibido -> %s", compra.toString()));
        try {
            productoService.venderProducto(transaccion.getIdProducto(), transaccion.getCantidad());
            transaccionRepositorio.save(transaccion);
            LOGGER.info("Venta realizada correctamente");

        } catch (ResourceNotFoundException e) {
            LOGGER.error("No se encontró el producto o cliente");
        }catch (ProductoInsuficienteException e){
            LOGGER.error("No se se cuenta con suficiente stock");
        }

    }


}
