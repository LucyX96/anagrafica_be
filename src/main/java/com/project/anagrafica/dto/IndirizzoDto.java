package com.project.anagrafica.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IndirizzoDto {
    private String via;
    private String numeroCivico;
    private String cap;
    private String comune;
    private String provincia;
    private String stato;
}
