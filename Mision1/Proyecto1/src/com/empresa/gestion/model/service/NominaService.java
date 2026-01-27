package com.empresa.gestion.model.service;

import com.empresa.gestion.model.model.Empleado;

public class NominaService {
    public double calcularSalarioAnual(Empleado empleado) {
        return empleado.getSalario() * 12;
    }

    public double calcularTotalNomina (double[] salarios) {
        double total = 0;
        for (int i = 0; i<salarios.length; i++) {
            total += salarios[i];
        }

        return total;
    }

    public void simularPagos (int meses) {
        int contador = 1;
        while (contador <= meses) {
            System.out.println("Procesando nomina del mes: " +contador);
            contador++;
        }
    }
}
