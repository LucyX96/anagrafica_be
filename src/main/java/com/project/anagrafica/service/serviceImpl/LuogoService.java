package com.project.anagrafica.service.serviceImpl;

import com.project.anagrafica.dto.LuogoDto;
import com.project.anagrafica.exception.BusinessException;
import com.project.anagrafica.exception.ErrorCode;
import com.project.anagrafica.mapper.LuogoMapper;
import com.project.anagrafica.model.Luogo;
import com.project.anagrafica.model.Persona;
import com.project.anagrafica.repository.LuogoRepository;
import com.project.anagrafica.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LuogoService {

    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private LuogoRepository luogoRepository;
    @Autowired
    private LuogoMapper luogoMapper;

    public LuogoDto aggiornaLuogoNascita(Long personaId, LuogoDto luogoDto) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new BusinessException(ErrorCode.PERSONA_NOT_FOUND));

        Luogo luogo = luogoMapper.toEntity(luogoDto);
        luogoRepository.save(luogo);
        persona.setLuogoNascita(luogo);
        personaRepository.save(persona);

        return luogoMapper.toDto(luogo);
    }
}
