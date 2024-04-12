package com.ecbackend.eClubTest.Services.impl;

import com.ecbackend.eClubTest.Entity.Producto;
import com.ecbackend.eClubTest.Services.ProductoService;
import com.ecbackend.eClubTest.exception.ProductoInsuficienteException;
import com.ecbackend.eClubTest.exception.ResourceNotFoundException;
import com.ecbackend.eClubTest.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {
    ProductoRepository productoRepository;
    @Override
    public Producto crearProducto(Producto producto) {
        producto.setCantidad(0);
        return productoRepository.save(producto);
    }

    @Override
    public void comprarProducto(Long idProducto, int cantidad) {
        Producto producto = productoRepository.findById(idProducto).orElseThrow(() -> new ResourceNotFoundException("No se encontro el producto con el id:" + idProducto));
        producto.setCantidad(producto.getCantidad() + cantidad);
        productoRepository.save(producto);
    }
    @Override
    public void venderProducto(Long idProducto, int cantidad) throws ProductoInsuficienteException {
        Producto producto = productoRepository.findById(idProducto).orElseThrow(() -> new ResourceNotFoundException("No se encontro el producto con el id:" + idProducto));
        if(producto.getCantidad() < cantidad)
            throw new ProductoInsuficienteException("No se cuenta con stock suficiente");
        producto.setCantidad(producto.getCantidad() - cantidad);
        productoRepository.save(producto);
    }

}
