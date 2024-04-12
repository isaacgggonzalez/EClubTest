package com.ecbackend.eClubTest.Services;

import com.ecbackend.eClubTest.Entity.Producto;
import com.ecbackend.eClubTest.exception.ProductoInsuficienteException;



public interface ProductoService {
    Producto crearProducto(Producto producto);
    void comprarProducto(Long idProducto, int cantidad);
    void venderProducto(Long idProducto, int cantidad) throws ProductoInsuficienteException;
}
