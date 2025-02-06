package com.angelodev.medvoll.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    private String telefono;

    private String documentoIdentidad;

    @Embedded
    private Direccion direccion;

    private Boolean activo;

    public Paciente(){}

    public Paciente(DatosRegistroPaciente datos) {
        this.activo = true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documentoIdentidad = datos.documentoIdentidad();
        this.direccion = new Direccion(datos.direccion());
    }

    public void actualizarDatos(DatosActualizarPaciente datosActualizarPaciente) {

        if (datosActualizarPaciente.nombre() != null){
            this.nombre=datosActualizarPaciente.nombre();
        }
        if (datosActualizarPaciente.telefono() != null){
            this.telefono=datosActualizarPaciente.telefono();
        }
        if (datosActualizarPaciente.direccion() != null){
            this.direccion=direccion.actualizarDatos(datosActualizarPaciente.direccion());
        }
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public void desactivarPaciente() {
        this.activo=false;
    }
}
