package hr.management.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.management.model.Employee;
import hr.management.model.Vehicle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonManager {
    static ObjectMapper objectMapper = new ObjectMapper();

    public static boolean saveEmployeesToJson(ArrayList<Employee> employees, String ruta){
        try {
            objectMapper.writeValue(new File(ruta),employees);
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    public static ArrayList<Employee> loadEmployeesFromJson(String ruta) {
        try {
            System.out.println("Cargando empleados desde: " + ruta);
            ArrayList<Employee> employees = objectMapper.readValue(new File(ruta),
                    objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Employee.class)
            );
            System.out.println("Empleados cargados: " + employees.size());
            return employees;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static boolean saveVehiclesToJson(ArrayList<Vehicle> vehicles, String ruta){
        try {
            objectMapper.writeValue(new File(ruta), vehicles);

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static ArrayList<Vehicle> loadVehiclesFromJson(String ruta){
        try {
            ArrayList<Vehicle> vehicles = objectMapper.readValue(new File(ruta),
                    objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Vehicle.class));

            return vehicles;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

