package com.project.anagrafica.controller;

import com.project.anagrafica.dto.DocumentoDto;
import com.project.anagrafica.exception.ErrorResponse;
import com.project.anagrafica.service.serviceImpl.DocumentoService;
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
@RequestMapping("${app.api.prefix}/documenti")
@RequiredArgsConstructor
@Tag(name = "Gestione Documenti", description = "API per la gestione dei documenti delle persone")
public class DocumentoController {
    @Autowired
    private DocumentoService documentoService;

    @Operation(summary = "Aggiunge o aggiorna il documento associato a una persona")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Documento aggiornato o aggiunto con successo",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DocumentoDto.class))),
            @ApiResponse(responseCode = "404", description = "Persona non trovata",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping("/{idPersona}")
    public ResponseEntity<DocumentoDto> aggiornaDocumentoPersona(
            @PathVariable Long idPersona,
            @Valid @RequestBody DocumentoDto documentoDto) {
        DocumentoDto updated = documentoService.aggiornaDocumento(idPersona, documentoDto);
        return ResponseEntity.ok(updated);
    }
}

