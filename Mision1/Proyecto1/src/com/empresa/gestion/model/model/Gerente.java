package com.empresa.gestion.model.model;

public class Gerente extends Empleado{
    private String departamento;
    private double bono;


    public Gerente(String nombre, int edad, boolean activo, char genero, double salario, int horasTrabajadas, double bono, String departamento){
        super(nombre, edad, activo, genero, salario, horasTrabajadas);
        this.departamento = departamento;
        this.bono = bono;
    }

    public String getDepartamento(){
        return departamento;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    //♻️Sobreescritura de metodo, Polimorfismo
    @Override
    public void presentarse(){
        System.out.println("Soy el gerente "+getNombre()+" y estoy a cargo del departamento de "+departamento);
    }

    @Override
    public double calcularSalarioMensual() {
        double salario = super.calcularSalarioMensual();
        return salario + bono;
    }
}
