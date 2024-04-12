package com.ecbackend.eClubTest.Controller;

import com.ecbackend.eClubTest.Entity.Producto;
import com.ecbackend.eClubTest.Services.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/productos")
public class ProductoController {
    ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        Producto producto1 = productoService.crearProducto (producto);
        return new ResponseEntity<>(producto1, HttpStatus.CREATED);
    }

}
