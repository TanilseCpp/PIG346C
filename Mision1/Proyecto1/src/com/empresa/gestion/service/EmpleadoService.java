package com.empresa.gestion.service;
import com.empresa.gestion.model.Empleado;
import java.util.ArrayList;

public class EmpleadoService {
    private ArrayList<Empleado> empleados = new ArrayList<>();
    //Agregar
    public void agregarEmpleado(Empleado emp) {
        empleados.add(emp);
        System.out.println("Empleado agregado");
    }

    //Listar
    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados");
            return;
        }

        for (Empleado e : empleados) {
            System.out.println(e.resumen());
        }
    }

    //Eliminar
    public void eliminarEmpleado(int id) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId() == id) {
                empleados.remove(i);
                System.out.println("Empleado eliminado");
                return;
            }
        }

        System.out.println("Empleado no encontrado");
    }

    //Consultar
    public void consultarEmpleado(int id) {
        for(Empleado e : empleados) {
            if (e.getId()==id){
                System.out.println(e.resumen());
                return;
            }
        }

        System.out.println("Empleado no encontrado");
    }
}
