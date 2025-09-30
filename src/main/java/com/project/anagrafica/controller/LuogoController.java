package com.project.anagrafica.controller;

import com.project.anagrafica.dto.LuogoDto;
import com.project.anagrafica.exception.ErrorResponse;
import com.project.anagrafica.service.serviceImpl.LuogoService;
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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.api.prefix}/luoghi")
@RequiredArgsConstructor
@Tag(name = "Gestione Luoghi", description = "API per la gestione del luogo di nascita delle persone")
public class LuogoController {
    @Autowired
    private LuogoService luogoService;

    @Operation(summary = "Aggiorna il luogo di nascita")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Luogo aggiornato correttamente",
                    content = @Content(schema = @Schema(implementation = LuogoDto.class))),
            @ApiResponse(responseCode = "404", description = "Persona non trovata",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping("/{personaId}/nascita")
    public ResponseEntity<LuogoDto> aggiornaLuogoNascita(
            @PathVariable Long personaId,
            @Valid @RequestBody LuogoDto luogoDto) {
        return ResponseEntity.ok(luogoService.aggiornaLuogoNascita(personaId, luogoDto));
    }
}

