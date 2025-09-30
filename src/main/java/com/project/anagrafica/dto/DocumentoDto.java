package com.project.anagrafica.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DocumentoDto {
    private String tipo;
    private String numero;
    private String rilasciatoDa;
    private LocalDate dataRilascio;
    private LocalDate dataScadenza;
}

