package com.angelodev.medvoll.modelo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {

    private String calle;

    private String numero;

    private String distrito;

    private String complemento;

    private String ciudad;

    // Constructor por defecto (obligatorio)
    public Direccion() {
    }

    public Direccion(DatosDireccion direccion) {

        this.calle = direccion.calle();

        this.numero = direccion.numero();

        this.distrito = direccion.distrito();

        this.complemento = direccion.complemento();

        this.ciudad = direccion.ciudad();
    }

    public Direccion actualizarDatos(DatosDireccion direccion) {
        this.calle = direccion.calle();

        this.numero = direccion.numero();

        this.distrito = direccion.distrito();

        this.complemento = direccion.complemento();

        this.ciudad = direccion.ciudad();

        return this;
    }

    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }

    public String getDistrito() {
        return distrito;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCiudad() {
        return ciudad;
    }
}
