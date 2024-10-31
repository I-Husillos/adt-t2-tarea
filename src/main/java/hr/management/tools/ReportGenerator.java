package hr.management.tools;

import hr.management.model.Employee;
import hr.management.model.Vehicle;

import java.io.*;
import java.util.ArrayList;

public class ReportGenerator {
    public static void generateReport(ArrayList<Employee> employees, ArrayList<Vehicle> vehicles, String ruta){
        ArrayList<Employee> empleados = JsonManager.loadEmployeesFromJson("./data/employees.json");
        ArrayList<Vehicle> vehiculos = JsonManager.loadVehiclesFromJson("./data/vehicles.json");



        try {
            FileWriter fileWriter = new FileWriter(ruta);
            fileWriter.write("Informe de empleados con vehículos asignados\n");
            fileWriter.write("===========================================\n");


            for (Employee employee: empleados){
                if (employee.getVehiclePlate() != null && !employee.getVehiclePlate().equals("Ninguno")){
                    fileWriter.write("Empleado: " + "\n");
                    fileWriter.write("\tDNI : "+employee.getDni() + "\n");
                    fileWriter.write("\tNombre : "+employee.getName() + "\n");
                    fileWriter.write("\tAño Contratado : "+employee.getYearHired() + "\n");

                    for (Vehicle vehicle: vehiculos){
                        if (vehicle.getPlate().equals(employee.getVehiclePlate())){
                            fileWriter.write("\tVehículo:\n");
                            fileWriter.write("\t\tMarca: " + vehicle.getBrand() + "\n");
                            fileWriter.write("\t\tModelo: " + vehicle.getModel() + "\n");
                            fileWriter.write("\t\tMatrícula: " + vehicle.getPlate() + "\n");
                            fileWriter.write("\t\tAño: " + vehicle.getYearBought() + "\n");
                        }
                    }


                    fileWriter.write("===========================================\n");
                }

            }

            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}



