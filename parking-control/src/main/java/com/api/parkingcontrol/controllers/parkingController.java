package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dttos.ParkingSpotDttos;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingspotRepository;
import com.api.parkingcontrol.services.ParkingSpotServices;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/parking-spot") // uri a nivel de classe
public class parkingController {
    @Autowired
    ParkingSpotServices parkingSpotServices; //  Ponto de Injeção



    @PostMapping
    public ResponseEntity<Object> saveParkinking(@RequestBody @Valid ParkingSpotDttos parkingSpotDttos){

        if(parkingSpotServices.existsByLicensePlateCar(parkingSpotDttos.getLicensePlateCar())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Placa ja cadrastrada");
        }

        if (parkingSpotServices.existsByParkingSpotNumber(parkingSpotDttos.getParkingSpotNumber())){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("Número da vaga da vaga ja cadrastrada");
        }

        if (parkingSpotServices.existsByApartmentAndBlock(parkingSpotDttos.getApartment(),parkingSpotDttos.getBlock())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Apartamento ou bloco ja cadrastrado");
        }



        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDttos,parkingSpotModel); // convertendo de dttos pra models porque na hora
        // de salva no banco de dados ta salvando a classe models

        parkingSpotModel.setRegistrationDate(LocalDate.now(ZoneId.of("UTC"))); // Tou adicionando minha data
        // manualmente porque a classe ddtos nao tem a data
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotServices.save(parkingSpotModel));

    }

    @GetMapping
    public ResponseEntity<List<ParkingSpotModel>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotServices.findAll());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID id) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotServices.findbyId(id);


        if(!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }



        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable(value = "id") UUID id){
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotServices.findbyId(id);

        if (!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }

        parkingSpotServices.delete(parkingSpotModelOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body("deletado com sucesso");


    }
   // FALTA FAZER AS VALIDAÇÕES Caso eu atualize a placa e a placa ja existem

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") UUID id,@RequestBody @Valid ParkingSpotModel parkingSpotDttos){
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotServices.findbyId(id);// mim retorna um objeto se o id existir

        if(!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID NÃO ENCONTRADO");
        }

        ParkingSpotModel parkingSpotModel = parkingSpotModelOptional.get();

        parkingSpotModel.setApartment(parkingSpotDttos.getApartment());
        parkingSpotModel.setBlock(parkingSpotDttos.getBlock());
        parkingSpotModel.setParkingSpotNumber(parkingSpotDttos.getParkingSpotNumber());
        parkingSpotModel.setLicensePlateCar(parkingSpotDttos.getLicensePlateCar());
        parkingSpotModel.setBrandcar(parkingSpotDttos.getBrandcar());
        parkingSpotModel.setColorCar(parkingSpotDttos.getColorCar());
        parkingSpotModel.setModelcar(parkingSpotDttos.getModelcar());
        parkingSpotModel.setResponsibleName(parkingSpotDttos.getResponsibleName());


        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotServices.save(parkingSpotModel));



    }

}

/*
* @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") UUID id,@RequestBody @Valid ParkingSpotDttos parkingSpotDttos){
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotServices.findbyId(id);

        if(!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID NÃO ENCONTRADO");
        }
          ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDttos,parkingSpotModel); // convertendo de dttos pra models porque na hora
        // de salva no banco de dados ta salvando a classe models

        parkingSpotModel.setRegistrationDate(LocalDate.now(ZoneId.of("UTC"))); // Tou adicionando minha data
        // manualmente porque a classe ddtos nao tem a data
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotServices.save(parkingSpotModel));

*
* }

* */
