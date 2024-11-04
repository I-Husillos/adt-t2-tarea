package hr.management.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    @JsonProperty("dni")
    private String dni;
    @JsonProperty("nombre")
    private String name;
    @JsonProperty("añoContratado")
    private int yearHired;
    @JsonProperty("matriculaVehiculo")
    private String vehiclePlate;

    public Employee(String dni, String name, int yearHired, String vehiclePlate) {
        this.dni = dni;
        this.name = name;
        this.yearHired = yearHired;
        this.vehiclePlate = vehiclePlate;
    }

    public Employee(String dni, String name, int yearHired) {
        this.dni = dni;
        this.name = name;
        this.yearHired = yearHired;
    }

    public Employee() {
    }

    public void assignVehicleWithPlate(String vehiclePlate){
        this.vehiclePlate = vehiclePlate;
        System.out.println("Vehículo con matrícula " + vehiclePlate + " asignado a " + name);
    }


    public void unassignVehicle(){
        if(vehiclePlate!=null && !vehiclePlate.isEmpty()){
            this.vehiclePlate=null;
            System.out.println("Vehículo con matrícula " + vehiclePlate + " desasignado de " + name);
        }else{
            System.out.println(name + " no tiene un vehículo asignado.");
        }
    }



    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearHired() {
        return yearHired;
    }

    public void setYearHired(int yearHired) {
        this.yearHired = yearHired;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    @Override
    public String toString() {
        return "Empleado [DNI: " + dni
                + ", Nombre: " + name
                + ", Año Contratado: " + yearHired
                + ", Matrícula del Vehículo: " + (vehiclePlate != null ? vehiclePlate : "Ninguno")
                + "]";
    }


}
