package com.project.anagrafica.mapper;

import com.project.anagrafica.dto.DocumentoDto;
import com.project.anagrafica.model.Documento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {
    Documento toEntity(DocumentoDto dto);
    DocumentoDto toDto(Documento entity);
}
