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
        } else {
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
        File folder = new File("data/employeeDocuments");

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

    public void removeEmployee(String dni){
        Employee employee = findEmployeeByDni(dni);
        if (employee!= null){
            empleados.remove(employee);
            deleteFolder(new File("data/employeeDocuments/" + dni));
            System.out.println("Empleado con DNI " + dni + " eliminado de la lista.");
            System.out.println("Carpeta del empleado con DNI " + dni + " eliminada.");
        } else {
            System.out.println("La carpeta del empleado con DNI " + dni + " no existe.");
        }
    }


    public void deleteFolder(File folder) {
        if (folder.exists()) {
            File[] files = folder.listFiles();
            if (files!= null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteFolder(file);
                    } else {
                        file.delete();
                    }
                }
            }
            folder.delete();
        }
    }
}

