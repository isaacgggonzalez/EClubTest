package com.ecbackend.eClubTest.repository;

import com.ecbackend.eClubTest.Entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepositorio extends JpaRepository<Transaccion, Long> {
}
