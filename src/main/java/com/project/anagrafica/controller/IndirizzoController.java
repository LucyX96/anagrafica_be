package com.project.anagrafica.controller;


import com.project.anagrafica.dto.IndirizzoDto;
import com.project.anagrafica.service.serviceImpl.IndirizzoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.api.prefix}/indirizzi")
@RequiredArgsConstructor
@Tag(name = "Gestione Indirizzi", description = "API per la gestione degli indirizzi delle persone")
public class IndirizzoController {
    @Autowired
    private IndirizzoService indirizzoService;

    @Operation(summary = "Aggiorna l'indirizzo di residenza")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Indirizzo aggiornato correttamente",
                    content = @Content(schema = @Schema(implementation = IndirizzoDto.class))),
            @ApiResponse(responseCode = "404", description = "Persona non trovata",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping("/{personaId}/residenza")
    public ResponseEntity<IndirizzoDto> aggiornaResidenza(
            @PathVariable Long personaId,
            @Valid @RequestBody IndirizzoDto indirizzoDto) {
        return ResponseEntity.ok(indirizzoService.aggiornaResidenza(personaId, indirizzoDto));
    }

    @Operation(summary = "Aggiorna l'indirizzo di domicilio")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Indirizzo aggiornato correttamente",
                    content = @Content(schema = @Schema(implementation = IndirizzoDto.class))),
            @ApiResponse(responseCode = "404", description = "Persona non trovata",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping("/{personaId}/domicilio")
    public ResponseEntity<IndirizzoDto> aggiornaDomicilio(
            @PathVariable Long personaId,
            @Valid @RequestBody IndirizzoDto indirizzoDto) {
        return ResponseEntity.ok(indirizzoService.aggiornaDomicilio(personaId, indirizzoDto));
    }
}

