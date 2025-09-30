package com.project.anagrafica.repository;

import com.project.anagrafica.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    boolean existsByCodiceFiscale(String codiceFiscale);

    @Query("""
                SELECT p FROM Persona p
                WHERE (:nome IS NULL OR LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%')))
                  AND (:cognome IS NULL OR LOWER(p.cognome) LIKE LOWER(CONCAT('%', :cognome, '%')))
                  AND (:codiceFiscale IS NULL OR p.codiceFiscale = :codiceFiscale)
                  AND (:email IS NULL OR LOWER(p.email) LIKE LOWER(CONCAT('%', :email, '%')))
                  AND (:telefono IS NULL OR LOWER(p.telefono) LIKE LOWER(CONCAT('%', :telefono, '%')))
            """)
    List<Persona> findByCriteria(
            @Param("nome") String nome,
            @Param("cognome") String cognome,
            @Param("codiceFiscale") String codiceFiscale,
            @Param("email") String email,
            @Param("telefono") String telefono
    );

}


