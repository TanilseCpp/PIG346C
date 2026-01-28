package com.empresa.gestion.model;

public class Persona {
    //🔐 Encapsulación
    protected int id;
    protected String nombre;
    protected int edad;
    protected boolean activo; // True o False
    protected char genero; // M o F
    //🧱 Constructor
    public Persona(int id, String nombre, int edad, boolean activo, char genero) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.activo = activo;
        this.genero = genero;
    }
    
    public int getId() {
        return id;
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

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

//Metodos
    public void presentarse() {
        System.out.println("Hola, soy "+nombre+" y tengo "+edad+" anios");
    }

    public void mostrarInfoBasica() {
        System.out.println("Nombre: "+nombre);
        System.out.println("Edad: "+edad);
        System.out.println("Activo: "+activo);
        System.out.println("Genero: "+genero);
    }
    
}
