package com.project.anagrafica.service;

import com.project.anagrafica.dto.dtoIN.PersonaDtoInput;
import com.project.anagrafica.dto.dtoOUT.PersonaDtoOutput;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    List<PersonaDtoOutput> cercaPersone(
            Optional<String> nome,
            Optional<String> cognome,
            Optional<String> codiceFiscale,
            Optional<String> email,
            Optional<String> telefono
    );

    PersonaDtoOutput getPersonaById(Long id);

    PersonaDtoOutput creaPersona(PersonaDtoInput personaDtoInput);

    PersonaDtoOutput aggiornaPersona(Long id, PersonaDtoInput personaDtoInput);

    void eliminaPersona(Long id);
}
