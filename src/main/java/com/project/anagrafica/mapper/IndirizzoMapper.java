package com.project.anagrafica.mapper;

import com.project.anagrafica.dto.IndirizzoDto;
import com.project.anagrafica.model.Indirizzo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IndirizzoMapper {
    Indirizzo toEntity(IndirizzoDto dto);
    IndirizzoDto toDto(Indirizzo entity);
}
