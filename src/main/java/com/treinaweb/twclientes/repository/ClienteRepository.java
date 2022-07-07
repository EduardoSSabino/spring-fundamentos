package com.treinaweb.twclientes.repository;

import com.treinaweb.twclientes.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
