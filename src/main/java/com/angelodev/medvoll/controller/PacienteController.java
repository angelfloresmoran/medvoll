package com.angelodev.medvoll.controller;

import com.angelodev.medvoll.dto.PacienteDTO;
import com.angelodev.medvoll.modelo.DatosActualizarPaciente;
import com.angelodev.medvoll.modelo.DatosRegistroPaciente;
import com.angelodev.medvoll.modelo.Medico;
import com.angelodev.medvoll.modelo.Paciente;
import com.angelodev.medvoll.repository.IPacienteRepositorio;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private IPacienteRepositorio pacienteRepositorio;

    @PostMapping
    public void registrarPaciente(@RequestBody @Valid DatosRegistroPaciente datosRegistroPaciente){
        pacienteRepositorio.save(new Paciente(datosRegistroPaciente));
    }

    @GetMapping
    public Page<PacienteDTO> listar(@PageableDefault(page = 0, size = 10, sort = {"nombre"}) Pageable paginacion) {
        return  pacienteRepositorio.findByActivoTrue(paginacion).map(PacienteDTO::new);
    }

    @PutMapping
    @Transactional
    public void actualizarPaciente(@RequestBody @Valid DatosActualizarPaciente datosActualizarPaciente){
        Paciente paciente = pacienteRepositorio.getReferenceById(datosActualizarPaciente.id());
        paciente.actualizarDatos(datosActualizarPaciente);
    }

    //DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarPaciente(@PathVariable Long id){
        Paciente paciente = pacienteRepositorio.getReferenceById(id);
        paciente.desactivarPaciente();
    }

}
