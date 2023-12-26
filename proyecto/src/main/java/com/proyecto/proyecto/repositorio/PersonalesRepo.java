package com.proyecto.proyecto.repositorio;

import com.proyecto.proyecto.entidades.EntidadPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalesRepo extends JpaRepository<EntidadPersonal, Long> {
}
