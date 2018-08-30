package com.example.diego.logindiegohuanaco.models;

import com.example.diego.logindiegohuanaco.application.MyApplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Empleados extends RealmObject {

    @PrimaryKey
    private int id;
    private String rut;
    private String nombre;
    private int edad;
    private String direccion;
    private int sueldo;
    private String cargo;

    public Empleados() {} // Only for Realm

    public Empleados(String rut, String nombre, int edad, String direccion, int sueldo, String cargo) {
        this.id = MyApplication.EmpleadoID.incrementAndGet();
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.sueldo = sueldo;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}