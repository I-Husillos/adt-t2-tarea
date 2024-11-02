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

    public Vehicle findVehicleByPlate(Vehicle plate){
        for(Vehicle vehicle: vehiculos){
            if (vehicle.getPlate().contains(plate.getPlate())){
                return vehicle;
            }
        }
        return null;
    }

    public boolean assignVehicleToEmployee(String dni, Vehicle plate){
        Employee employee = findEmployeeByDni(dni);
        Vehicle vehicle = findVehicleByPlate(plate);

        if (employee!=null && vehicle!=null){
            employee.assignVehicleWithPlate(plate.getPlate());
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

    /*
    * removeEmployee: Acepta un dni que pertenece a un empleado que deberá borrar de la lista actual. Deberá ocuparse de eliminar la carpeta asociada a este empleado que se encontrará dentro de la carpeta data. Si logra eliminar el empleado, imprime "Empleado con DNI " + dni + " eliminado de la lista.". Dado que también tiene que eliminar la carpeta, imprimirá "Carpeta del empleado con DNI " + dni + " eliminada." o "La carpeta del empleado con DNI " + dni + " no existe." en su caso.
    * */

    public void removeEmployee(String dni){
        Employee employee = findEmployeeByDni(dni);
        if (employee!=null){
            empleados.remove(employee);
            File folder = new File("./data/employeeDocuments/" + dni);
            if (folder.exists()){
                folder.delete();
                System.out.println("Carpeta del empleado con DNI " + dni + " eliminada.");
            } else {
                System.out.println("La carpeta del empleado con DNI " + dni + " no existe.");
            }
        } else {
            System.out.println("Empleado con DNI " + dni + " no encontrado.");
        }
    }


}

