package com.project.anagrafica.controller;

import com.project.anagrafica.dto.dtoIN.PersonaDtoInput;
import com.project.anagrafica.dto.dtoOUT.PersonaDtoOutput;
import com.project.anagrafica.exception.ErrorResponse;
import com.project.anagrafica.service.PersonaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${app.api.prefix}/persone")
@RequiredArgsConstructor
@Tag(name = "Gestione Anagrafica", description = "API per la gestione dell'anagrafica delle persone")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @Operation(summary = "Ricerca persone per criteri multipli")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista di persone trovate",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonaDtoOutput.class))),
            @ApiResponse(responseCode = "500", description = "Errore interno del server",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/search")
    public ResponseEntity<List<PersonaDtoOutput>> searchPersone(
            @Parameter(description = "Nome della persona") @RequestParam Optional<String> nome,
            @Parameter(description = "Cognome della persona") @RequestParam Optional<String> cognome,
            @Parameter(description = "Codice fiscale della persona") @RequestParam Optional<String> codiceFiscale,
            @Parameter(description = "Email della persona") @RequestParam Optional<String> email,
            @Parameter(description = "Telefono della persona") @RequestParam Optional<String> telefono
    ) {
        List<PersonaDtoOutput> risultati = personaService.cercaPersone(
                nome, cognome, codiceFiscale, email, telefono);
        return ResponseEntity.ok(risultati);
    }

    @Operation(summary = "Recupera una persona per ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Persona trovata",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonaDtoOutput.class))),
            @ApiResponse(responseCode = "404", description = "Persona non trovata",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<PersonaDtoOutput> getPersonaById(
            @Parameter(description = "ID della persona da recuperare") @PathVariable Long id) {
        return ResponseEntity.ok(personaService.getPersonaById(id));
    }

    @Operation(summary = "Crea una nuova persona tramite form (campi singoli)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Persona creata con successo",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonaDtoOutput.class))),
            @ApiResponse(responseCode = "400", description = "Dati non validi",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/form")
    public ResponseEntity<PersonaDtoOutput> creaPersona(@RequestBody @Valid PersonaDtoInput personaDtoInput) {
        return ResponseEntity.ok(personaService.creaPersona(personaDtoInput));
    }


    @Operation(summary = "Aggiorna una persona esistente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Persona aggiornata con successo",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonaDtoOutput.class))),
            @ApiResponse(responseCode = "404", description = "Persona non trovata",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<PersonaDtoOutput> aggiornaPersona(
            @Parameter(description = "ID della persona da aggiornare") @PathVariable Long id,
            @Parameter(description = "Dati aggiornati della persona")
            @Valid @RequestBody PersonaDtoInput personaDtoInput) {
        return ResponseEntity.ok(personaService.aggiornaPersona(id, personaDtoInput));
    }

    @Operation(summary = "Elimina una persona")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Persona eliminata con successo"),
            @ApiResponse(responseCode = "404", description = "Persona non trovata",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminaPersona(
            @Parameter(description = "ID della persona da eliminare") @PathVariable Long id) {
        personaService.eliminaPersona(id);
        return ResponseEntity.noContent().build();
    }
}
