package com.project.anagrafica.dto.dtoIN;

import com.project.anagrafica.dto.DocumentoDto;
import com.project.anagrafica.dto.IndirizzoDto;
import com.project.anagrafica.dto.LuogoDto;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonaDtoInput {
    private String nome;
    private String cognome;
    private String sesso;
    private String codiceFiscale;
    private DocumentoDto documentoDto;
    private LocalDate dataNascita;
    private String cittadinanza;
    private IndirizzoDto indirizzoDto;
    private LuogoDto luogoDto;
    private String statoCivile;
    private String titoloStudio;
    private String professione;
    private Integer numeroFigli;
    private String email;
    private String telefono;
    private String note;

}

