package com.coupling.landingpage.controller;

import com.coupling.landingpage.model.User;
import com.coupling.landingpage.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signup")
@Tag(name = "Sign Up", description = "Erfassung der Kontaktdaten bei einer Anmeldung")
public class SignUpController {

    @Autowired
    private UserService userService;

    @Operation(
            summary = "User-Anmeldung speichern",
            description = "Speichert Name, E-Mail, Telefonnummer und Nachricht eines Users in der Datenbank.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User erfolgreich gespeichert"),
                    @ApiResponse(responseCode = "400", description = "Ungültige Eingabe")
            }
    )
    @PostMapping
    public ResponseEntity<User> createUser(
            @Parameter(description = "User-Objekt mit den nötigen Kontaktdaten", required = true)
            @RequestBody User user
    ) {
        User saved = userService.saveUser(user);
        return ResponseEntity.ok(saved);
    }
}
