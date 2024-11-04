package hr.management.tools;

import hr.management.model.Employee;
import hr.management.model.Vehicle;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Cargar datos de empleados y vehículos desde JSON
        ArrayList<Employee> employees = JsonManager.loadEmployeesFromJson("data/employees.json");
        ArrayList<Vehicle> vehicles = JsonManager.loadVehiclesFromJson("data/vehicles.json");


        // 2. Añadir un vehículo desde el archivo newVehicle1.xml
            Vehicle newVehicle = XmlManager.readVehicleFromXml("data/newVehicle.xml");
            vehicles.add(newVehicle);
            System.out.println("Nuevo vehículo añadido desde XML: " + newVehicle);

        // 3. Asignar el nuevo vehículo al empleado con DNI 87654321B
            EmployeeManager employeeManager = new EmployeeManager( employees, vehicles);
            boolean assigned = employeeManager.assignVehicleToEmployee("87654321B", newVehicle.getPlate());
            if (assigned) {
                System.out.println("Vehículo asignado correctamente al empleado con DNI 87654321B.");
            } else {
                System.out.println("No se pudo asignar el vehículo.");
            }

            // 4. Desasignar el vehículo del empleado Walter Smith
            boolean unassigned = employeeManager.unassignVehicleFromEmployee("23456789C");
            if (unassigned) {
                System.out.println("Vehículo desasignado correctamente del empleado Walter Smith.");
            } else {
                System.out.println("No se pudo desasignar el vehículo del empleado Walter Smith.");
            }

        // 5. Generar un informe en formato TXT utilizando ReportGenerator
        ReportGenerator.generateReport(employees, vehicles, "data/informe.txt");
        System.out.println("Informe generado exitosamente en 'data/informe.txt'.");

        // 6. Imprimir todos los empleados con el método printAllEmployees
            System.out.println("Lista de empleados:");
            employeeManager.printAllEmployees();

        // Operación adicional: Guardar de nuevo los datos actualizados en los archivos JSON
            JsonManager.saveEmployeesToJson(employees, "data/employees.json");
            JsonManager.saveVehiclesToJson(vehicles, "data/vehicles.json");
            System.out.println("Datos actualizados guardados en archivos JSON.");

    }
}
