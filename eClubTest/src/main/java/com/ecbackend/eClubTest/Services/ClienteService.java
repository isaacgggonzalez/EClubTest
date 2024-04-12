package com.ecbackend.eClubTest.Services;

import com.ecbackend.eClubTest.Entity.Cliente;

public interface ClienteService {
    Cliente crearCliente(Cliente cliente);
    Cliente obtenerCliente(Long idCliente);
}
