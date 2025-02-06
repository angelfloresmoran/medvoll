package com.angelodev.medvoll.dto;

import com.angelodev.medvoll.modelo.Medico;

public record MedicoDTO(
        Long id,

        String nombre,

        String especialidad,

        String documento,

        String email
) {
    public MedicoDTO (Medico medico){
        this(medico.getId(), medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
    }
}
