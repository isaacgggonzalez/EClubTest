package com.ecbackend.eClubTest.Mapper;

import com.ecbackend.eClubTest.Dto.TransaccionDto;
import com.ecbackend.eClubTest.Entity.Transaccion;

import java.util.Date;

public class TransaccionMapper {
    public static Transaccion TransaccionDtoToCompra(TransaccionDto transaccionDto){
        Transaccion transaccion = new Transaccion();
        transaccion.setTipoTransaccion("Compra");
        transaccion.setIdCLienteProveedor(transaccionDto.getIdClienteProveedor());
        transaccion.setIdProducto(transaccionDto.getIdProducto());
        transaccion.setCantidad(transaccionDto.getCantidad());
     return transaccion;
    }
    public static Transaccion TransaccionDtoToVenta(TransaccionDto transaccionDto){
        Transaccion transaccion = new Transaccion();
        transaccion.setTipoTransaccion("Venta");
        transaccion.setIdCLienteProveedor(transaccionDto.getIdClienteProveedor());
        transaccion.setIdProducto(transaccionDto.getIdProducto());
        transaccion.setCantidad(transaccionDto.getCantidad());
        return transaccion;
    }
}
