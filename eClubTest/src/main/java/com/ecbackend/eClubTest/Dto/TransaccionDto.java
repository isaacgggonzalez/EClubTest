package com.ecbackend.eClubTest.Dto;

import lombok.Data;

@Data
public class TransaccionDto {
    private Long idClienteProveedor;
    private Long idProducto;
    private int cantidad;
}
