package com.empresa.gestion.app;
import com.empresa.gestion.model.*;
import com.empresa.gestion.service.*;

public class Main {
    public static void main(String[] args) { 
        Empleado empleado1 = new Empleado(1, "Juan", 30, true, 'M', 5000, 160);
        Gerente gerente1 = new Gerente(1, "Ana", 40, true,  'F', 10000, 160, 2000, "Ventas");
        empleado1.presentarse();
        gerente1.presentarse();
        NominaService nomina = new NominaService();
        System.out.println("=== EMPLEADO ===");
        empleado1.mostrarInfoBasica();
        System.out.println("salario: "+empleado1.calcularSalarioMensual());
        System.out.println("Salario anual: $"+nomina.calcularSalarioAnual(empleado1));
        System.out.println("Puede trabajar? "+empleado1.puedeTrabajar());
        System.out.println("Genero: " +empleado1.obtenerTipoEmpleado());
        System.out.println("=== GERENTE ===");
        gerente1.mostrarInfoBasica();
        System.out.println("salario: "+gerente1.calcularSalarioMensual());
        System.out.println("Salario anual: $"+nomina.calcularSalarioAnual(gerente1));
        System.out.println("Puede trabajar? "+gerente1.puedeTrabajar());
        System.out.println("Genero: " +gerente1.obtenerTipoEmpleado());

        double[] salarios= {2000, 1000, 5000};
        System.out.println("Calcular Total Nomina " +nomina.calcularTotalNomina(salarios));

        int meses = 3;
        nomina.simularPagos(meses);
    } 
}
