package com.empresa.gestion.model.service;

import com.empresa.gestion.model.model.Empleado;

public class NominaService {
    public double calcularSalarioAnual(Empleado empleado) {
        return empleado.getSalario() * 12;
    }
}
