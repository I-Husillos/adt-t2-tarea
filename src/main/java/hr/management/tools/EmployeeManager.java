package hr.management.tools;

import hr.management.model.Employee;
import hr.management.model.Vehicle;

import java.io.*;
import java.util.ArrayList;

public class EmployeeManager {
    ArrayList<Employee> empleados;
    ArrayList<Vehicle> vehiculos;

    public EmployeeManager(ArrayList<Employee> empleados, ArrayList<Vehicle> vehiculos) {
        this.empleados = empleados;
        this.vehiculos = vehiculos;
    }

    public Employee findEmployeeByDni(String dni){
        for (Employee employee: empleados){
            if(employee.getDni().contains(dni)){
                return employee;
            }
        }
        return null;

        /*try {
            FileReader reader = new FileReader("./data/employees.json");
            BufferedReader linea = new BufferedReader(reader);
            String text = linea.readLine();
            while (linea.ready()) {
                if (text.contains(dni)){

                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

    public Vehicle findVehicleByPlate(String plate){
        for(Vehicle vehicle: vehiculos){
            if (vehicle.getPlate().contains(plate)){
                return vehicle;
            }
        }
        return null;
    }

    public boolean assignVehicleToEmployee(String dni, String plate){
        Employee employee = findEmployeeByDni(dni);
        Vehicle vehicle = findVehicleByPlate(plate);

        if (employee!=null && vehicle!=null){
            employee.assignVehicleWithPlate(plate);
            return true;
        }
        return false;
    }

    public boolean unassignVehicleFromEmployee(String dni){
        Employee employeeDes = findEmployeeByDni(dni);

        if (employeeDes!=null){
            employeeDes.unassignVehicle();
            return true;
        }else {
            System.out.println("Empleado no encontrado.");
        }

        return false;
    }

    public void printAllEmployees(){
        for (Employee employee: empleados){
            System.out.println(employee);
        }
    }

    public void createEmployeeFolders(){
        File folder = new File("./data/employeeDocuments");

        if (folder.mkdir()){
            System.out.println("Carpeta 'employeeDocuments' creada.");

            for(Employee employee: empleados){
                File folders = new File(folder, employee.getDni());
                if (folders.mkdir()){
                    System.out.println("Carpeta creada para el empleado con DNI: " + employee.getDni());
                }else {
                    System.out.println("Error al crear la carpeta para el empleado: " + employee.getDni());
                }
            }
        }else {
            System.out.println("Error al crear la carpeta 'employeeDocuments'.");
        }

    }

}

