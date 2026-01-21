package com.empresa.gestion.model.model;

public class Empleado extends Persona {
    private double salario;

    public Empleado(String nombre, int edad, double salario){
        super(nombre,edad);
        this.salario = salario;
    }

    public double getSalario(){
        return salario;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }

    //♻️Sobreescritura de metodo, Polimorfismo
    @Override
    public void presentarse(){
        System.out.println("Soy el empleado "+getNombre()+"y mi salario es "+salario);
    }
}
