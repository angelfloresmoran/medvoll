package com.angelodev.medvoll.modelo;

public record DatosRespuestaMedico(

        Long id,

        String nombre,

        String email,

        String telefono,

        String documento,

        DatosDireccion direccion
) {
}
