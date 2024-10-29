package hr.management.tools;

import hr.management.model.Employee;
import hr.management.model.Vehicle;

import java.io.*;
import java.util.ArrayList;

public class ReportGenerator {
    public static void generateReport(ArrayList<Employee> employees, ArrayList<Vehicle> vehicles, String ruta){
        ArrayList<Employee> empleados = JsonManager.loadEmployeesFromJson("./data/employees.json");



        try {
            FileWriter fileWriter = new FileWriter(ruta);
            fileWriter.write("Informe de empleados con vehículos asignados\n");
            fileWriter.write("===========================================\n");

            for (Employee employee: empleados){
                fileWriter.write(employee.toString());
                fileWriter.write("\n");
                fileWriter.write("===========================================\n");
            }

            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}



