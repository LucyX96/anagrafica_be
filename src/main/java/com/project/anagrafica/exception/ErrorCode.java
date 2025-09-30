package com.project.anagrafica.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // ANAGRAFICA
    PERSONA_NOT_FOUND("ANA-001", "Persona non trovata.", HttpStatus.NOT_FOUND),
    DUPLICATE_CODICE_FISCALE("ANA-002", "Codice fiscale già presente nel sistema.", HttpStatus.CONFLICT),
    INVALID_DATA("ANA-003", "Dati anagrafici non validi.", HttpStatus.BAD_REQUEST),

    // GENERICI
    INTERNAL_ERROR("GEN-001", "Errore interno del server.", HttpStatus.INTERNAL_SERVER_ERROR),
    MALFORMED_REQUEST("GEN-002", "Richiesta malformata o incompleta.", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED_OPERATION("GEN-003", "Operazione non autorizzata.", HttpStatus.FORBIDDEN);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    ErrorCode(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
