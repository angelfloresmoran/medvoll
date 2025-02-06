package com.angelodev.medvoll.modelo;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarPaciente(
        @NotNull
        Long id,

        String nombre,

        String telefono,

        DatosDireccion direccion

) {

}
