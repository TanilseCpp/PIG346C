package com.empresa.gestion.model.model;

public class Gerente extends Empleado{
    private String departamento;

    public Gerente(String nombre, int edad, double salario, String departamento){
        super(nombre, edad, salario);
        this.departamento = departamento;
    }

    public String getDepartamento(){
        return departamento;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    //♻️Sobreescritura de metodo, Polimorfismo
    @Override
    public void presentarse(){
        System.out.println("Soy el gerente "+getNombre()+"y estoy a cargo del departamento de "+departamento);
    }
}
