package com.project.anagrafica.mapper;

import com.project.anagrafica.dto.LuogoDto;
import com.project.anagrafica.model.Luogo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LuogoMapper {
    Luogo toEntity(LuogoDto dto);
    LuogoDto toDto(Luogo entity);
}

