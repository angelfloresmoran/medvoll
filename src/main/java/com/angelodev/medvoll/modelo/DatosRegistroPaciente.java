package com.angelodev.medvoll.modelo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroPaciente(

        @NotBlank
        String nombre,

        @NotBlank @Email
        String email,

        @NotBlank
        String telefono,

        @NotBlank
        String documentoIdentidad,

        @NotNull
        @Valid
        DatosDireccion direccion
) {
}
