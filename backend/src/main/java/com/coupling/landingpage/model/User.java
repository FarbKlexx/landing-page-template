package com.coupling.landingpage.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "users")
@Schema(description = "User-Entität, die Kontaktdaten eines Anmelders enthält.")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Eindeutige ID des Users", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Name des Users", example = "Max Mustermann", required = true)
    private String name;

    @Schema(description = "E-Mail-Adresse des Users", example = "max@example.com", required = true)
    private String email;

    @Schema(description = "Postleitzahl des Users", example = "32051", required = true)
    private String postalCode;

    @Schema(description = "Straße des Users", example = "Leopoldstraße", required = true)
    private String street;

    @Schema(description = "Hausnummer des Users", example = "2-8", required = true)
    private String houseNumber;

    @Schema(description = "Telefonnummer", example = "+49 176 12345678", required = true)
    private String phone;

    @Schema(description = "Nachricht oder Zusatzinfo", example = "Ich möchte mich für den Newsletter anmelden.")
    private String message;
}
