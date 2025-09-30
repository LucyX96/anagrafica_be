package com.project.anagrafica.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LuogoDto {
    private String comune;
    private String provincia;
    private String stato;
}
