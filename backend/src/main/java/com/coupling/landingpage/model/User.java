package com.coupling.landingpage.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    @Schema(description = "Telefonnummer", example = "+49 176 12345678", required = true)
    private String phone;

    @Schema(description = "Nachricht oder Zusatzinfo", example = "Ich möchte mich für den Newsletter anmelden.")
    private String message;

    // --- Getter / Setter ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
