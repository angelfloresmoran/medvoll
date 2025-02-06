package com.angelodev.medvoll.dto;

import com.angelodev.medvoll.modelo.DatosDireccion;
import com.angelodev.medvoll.modelo.DatosRegistroPaciente;
import com.angelodev.medvoll.modelo.Direccion;
import com.angelodev.medvoll.modelo.Paciente;

public record PacienteDTO(

        Long id,

        String nombre,

        String email,

        String documentoIdentidad
) {

    public PacienteDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getDocumentoIdentidad());
    }

}
