package com.ecbackend.eClubTest.Services.impl;

import com.ecbackend.eClubTest.Entity.Cliente;
import com.ecbackend.eClubTest.Services.ClienteService;
import com.ecbackend.eClubTest.exception.ResourceNotFoundException;
import com.ecbackend.eClubTest.repository.ClienteRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {
    ClienteRepositorio clienteRepositorio;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        Cliente clienteGuardado = clienteRepositorio.save(cliente);
        return clienteGuardado;
    }

    @Override
    public Cliente obtenerCliente(Long idCliente) {
        Cliente cliente = clienteRepositorio.findById(idCliente).
                orElseThrow(() -> new ResourceNotFoundException("No se encontro el cliente con el id:" + idCliente));
        return cliente;
    }
}
