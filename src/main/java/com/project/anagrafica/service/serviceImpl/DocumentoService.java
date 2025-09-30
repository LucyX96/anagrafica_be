package com.project.anagrafica.service.serviceImpl;

import com.project.anagrafica.dto.DocumentoDto;
import com.project.anagrafica.exception.BusinessException;
import com.project.anagrafica.exception.ErrorCode;
import com.project.anagrafica.mapper.DocumentoMapper;
import com.project.anagrafica.model.Documento;
import com.project.anagrafica.model.Persona;
import com.project.anagrafica.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentoService {
    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    DocumentoMapper documentoMapper;



    public DocumentoDto aggiornaDocumento(Long idPersona, DocumentoDto dto) {
        Persona persona = personaRepository.findById(idPersona)
                .orElseThrow(() -> new BusinessException(ErrorCode.PERSONA_NOT_FOUND));

        Documento documento = documentoMapper.toEntity(dto);
        persona.setDocumento(documento);

        personaRepository.save(persona);
        return documentoMapper.toDto(documento);
    }

}

