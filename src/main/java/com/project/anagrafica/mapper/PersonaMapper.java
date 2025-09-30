package com.project.anagrafica.mapper;

import com.project.anagrafica.dto.dtoIN.PersonaDtoInput;
import com.project.anagrafica.dto.dtoOUT.PersonaDtoOutput;
import com.project.anagrafica.model.Persona;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    Persona toEntity(PersonaDtoInput dto);

    PersonaDtoOutput toDtoOut(Persona entity);

    List<PersonaDtoOutput> toDtoList(List<Persona> list);
}

