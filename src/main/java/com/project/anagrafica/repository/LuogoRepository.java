package com.project.anagrafica.repository;

import com.project.anagrafica.model.Luogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuogoRepository extends JpaRepository<Luogo, Long> {

}

