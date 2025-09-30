package com.project.anagrafica.dto.dtoOUT;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonaDtoOutput {
    private Long id;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String email;
    private String telefono;
}
