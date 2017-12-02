package com.i054114.citips.Models;

/**
 * Created by CAMILO on 2/12/2017.
 */

public class Cita {
    private Integer idC;
    private String namepaciente;
    private String cedula;
    private String telefono;

    private String nameDoctor;
    private String fecha;
    private String hora;


    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }

    public String getNamepaciente() {
        return namepaciente;
    }

    public void setNamepaciente(String namepaciente) {
        this.namepaciente = namepaciente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
