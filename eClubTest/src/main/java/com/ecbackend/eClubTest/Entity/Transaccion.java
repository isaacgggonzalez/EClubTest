package com.ecbackend.eClubTest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "transacciones")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idTransaccion;
    private Long idCLienteProveedor;
    private Long idProducto;
    private int cantidad;
    private String tipoTransaccion;
}
