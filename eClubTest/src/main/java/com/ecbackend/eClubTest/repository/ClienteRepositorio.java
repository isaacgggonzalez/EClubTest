package com.ecbackend.eClubTest.repository;

import com.ecbackend.eClubTest.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
