package com.ecbackend.eClubTest.Controller;

import com.ecbackend.eClubTest.Dto.TransaccionDto;
import com.ecbackend.eClubTest.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaccion")
public class TransaccionController {
    private RabbitMQJsonProducer jsonProducer;

    public TransaccionController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }


    @PostMapping("/compra")
    public ResponseEntity<String> sendCompra(@RequestBody TransaccionDto compra){
        jsonProducer.sendCompra(compra);
        return ResponseEntity.ok("Se ha enviado la compra a la cola");
    }
    @PostMapping("/venta")
    public ResponseEntity<String> sendVenta(@RequestBody TransaccionDto Venta){
        jsonProducer.sendVenta(Venta);
        return ResponseEntity.ok("Se ha enviado la venta a la cola");
    }
}
