package com.api.parkingcontrol.dttos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ParkingSpotDttos {

    // Existem uma serie de anotação da dependência do Validtion para fazer essas validações só usei @NotBlank e @Size
    @NotBlank
    private String parkingSpotNumber;

    @NotBlank  // @NotBlank vai verificar se o campo não é nulo
    @Size(max = 7) // @Size vai limita o número de caracteres
    private String licensePlateCar;

    @NotBlank
    private String brandcar;
    @NotBlank
    private String modelcar;

    @NotBlank
    private String colorCar;

    @NotBlank
    private String responsibleName;

    @NotBlank
    private String apartment;

    @NotBlank
    private String block;

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public String getBrandcar() {
        return brandcar;
    }

    public void setBrandcar(String brandcar) {
        this.brandcar = brandcar;
    }

    public String getModelcar() {
        return modelcar;
    }

    public void setModelcar(String modelcar) {
        this.modelcar = modelcar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
