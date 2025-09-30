package com.project.anagrafica.service.serviceImpl;

import com.project.anagrafica.dto.IndirizzoDto;
import com.project.anagrafica.exception.BusinessException;
import com.project.anagrafica.exception.ErrorCode;
import com.project.anagrafica.mapper.IndirizzoMapper;
import com.project.anagrafica.model.Indirizzo;
import com.project.anagrafica.model.Persona;
import com.project.anagrafica.repository.IndirizzoRepository;
import com.project.anagrafica.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndirizzoService {

    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private IndirizzoRepository indirizzoRepository;
    @Autowired
    private IndirizzoMapper indirizzoMapper;

    public IndirizzoDto aggiornaResidenza(Long personaId, IndirizzoDto indirizzoDto) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new BusinessException(ErrorCode.PERSONA_NOT_FOUND));

        Indirizzo residenza = indirizzoMapper.toEntity(indirizzoDto);
        indirizzoRepository.save(residenza);
        persona.setResidenza(residenza);
        personaRepository.save(persona);

        return indirizzoMapper.toDto(residenza);
    }

    public IndirizzoDto aggiornaDomicilio(Long personaId, IndirizzoDto indirizzoDto) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new BusinessException(ErrorCode.PERSONA_NOT_FOUND));

        Indirizzo domicilio = indirizzoMapper.toEntity(indirizzoDto);
        indirizzoRepository.save(domicilio);
        persona.setDomicilio(domicilio);
        personaRepository.save(persona);

        return indirizzoMapper.toDto(domicilio);
    }
}
