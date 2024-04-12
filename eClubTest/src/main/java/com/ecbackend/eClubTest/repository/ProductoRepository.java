package com.ecbackend.eClubTest.repository;

import com.ecbackend.eClubTest.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
