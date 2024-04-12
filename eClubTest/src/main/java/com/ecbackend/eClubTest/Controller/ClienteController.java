package com.ecbackend.eClubTest.Controller;

import com.ecbackend.eClubTest.Entity.Cliente;
import com.ecbackend.eClubTest.Services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cliente")
public class ClienteController {
    ClienteService clienteService;
    @PostMapping
    public ResponseEntity<Cliente> CrearCliente(@RequestBody Cliente cliente){
       Cliente clienteguardado = clienteService.crearCliente(cliente);
       return ResponseEntity.ok(clienteguardado);
    }
}
