package com.project.anagrafica.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "persone")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;
    private String sesso;
    private String codiceFiscale;

    private LocalDate dataNascita;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "luogo_nascita_id")
    private Luogo luogoNascita;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "residenza_id")
    private Indirizzo residenza;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Indirizzo domicilio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documento_id")
    private Documento documento;

    private String cittadinanza;
    private String statoCivile;
    private String titoloStudio;
    private String professione;
    private Integer numeroFigli;
    private String email;
    private String telefono;
    private String note;
}


