package com.api.parkingcontrol.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_PARKIND_SPOT")
public class ParkingSpotModel implements Serializable {
    private static final  long serialVersionUID = 1L;// id serializable. Conversão que vai ser feita por debaixo dos panos
    // de objeto java para bytes para ser salva no banco de dados

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false,unique = true, length = 10)// nullble nao pode ser nula campo, unique esse campo vai ser unico
    private String parkingSpotNumber;

    @Column(nullable = false,unique = true,length = 7)
    private String licensePlateCar;

    @Column(nullable = false,length = 70)
    private String brandcar;

    @Column(nullable = false,length = 70)
    private String modelcar;

    @Column(nullable = false,length = 70)
    private String colorCar;

    @Column(nullable = false)
    private LocalDate registrationDate;

    @Column(nullable = false,length = 130)
    private String responsibleName;

    @Column(nullable = false,length = 70)
    private String apartment;

    @Column(nullable = false,length = 70)
    private String block;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
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
