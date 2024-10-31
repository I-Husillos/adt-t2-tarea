package hr.management.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vehicle {

    @JsonProperty("matricula")
    String plate;
    @JsonProperty("marca")
    String brand;
    @JsonProperty("modelo")
    String model;
    @JsonProperty("añoCompra")
    int yearBought;

    public Vehicle(String plate, String brand, String model, int yearBought) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.yearBought = yearBought;
    }

    public Vehicle() {
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearBought() {
        return yearBought;
    }

    public void setYearBought(int yearBought) {
        this.yearBought = yearBought;
    }

    @Override
    public String toString() {
        return "Vehículo [Marca: " + brand
                + ", Modelo: " + model
                + ", Matrícula: " + plate
                + ", Año de Compra: " + yearBought
                + "]";
    }
}
