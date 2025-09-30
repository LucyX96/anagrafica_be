package com.project.anagrafica.service.serviceImpl;

import com.project.anagrafica.dto.dtoIN.PersonaDtoInput;
import com.project.anagrafica.dto.dtoOUT.PersonaDtoOutput;
import com.project.anagrafica.exception.BusinessException;
import com.project.anagrafica.exception.ErrorCode;
import com.project.anagrafica.mapper.PersonaMapper;
import com.project.anagrafica.model.Persona;
import com.project.anagrafica.repository.PersonaRepository;
import com.project.anagrafica.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;

    @Override
    public List<PersonaDtoOutput> cercaPersone(
            Optional<String> nome,
            Optional<String> cognome,
            Optional<String> codiceFiscale,
            Optional<String> email,
            Optional<String> telefono
    ) {
        List<Persona> risultati = personaRepository.findByCriteria(
                nome.orElse(null),
                cognome.orElse(null),
                codiceFiscale.orElse(null),
                email.orElse(null),
                telefono.orElse(null)
        );

        return risultati.stream()
                .map(personaMapper::toDtoOut)
                .toList();
    }


    @Override
    public PersonaDtoOutput getPersonaById(Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.PERSONA_NOT_FOUND));
        return personaMapper.toDtoOut(persona);
    }

    @Override
    public PersonaDtoOutput creaPersona(PersonaDtoInput personaDtoInput) {
        Persona persona = personaMapper.toEntity(personaDtoInput);
        persona = personaRepository.save(persona);
        return personaMapper.toDtoOut(persona);
    }

    @Override
    public PersonaDtoOutput aggiornaPersona(Long id, PersonaDtoInput personaDtoInput) {
        Persona esistente = personaRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.PERSONA_NOT_FOUND));

        Persona aggiornata = personaMapper.toEntity(personaDtoInput);
        aggiornata.setId(esistente.getId());

        return personaMapper.toDtoOut(personaRepository.save(aggiornata));
    }

    @Override
    public void eliminaPersona(Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.PERSONA_NOT_FOUND));
        personaRepository.delete(persona);
    }
}
