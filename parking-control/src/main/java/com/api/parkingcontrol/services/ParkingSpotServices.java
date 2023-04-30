

package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingspotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotServices {

   @Autowired
   ParkingspotRepository parkingspotRepository; // Ponto de injeção  do ParkingSpotRepository também podia criar esse
   // ponto de injeção via construtor



   @Transactional
   public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
      return parkingspotRepository.save(parkingSpotModel);
   }

   @Transactional
   public void delete(ParkingSpotModel parkingSpotModel) {
      parkingspotRepository.delete(parkingSpotModel);
   }

   public List<ParkingSpotModel> findAll() {
      return parkingspotRepository.findAll();

   }

   public Optional<ParkingSpotModel> findbyId(UUID id) {
      return parkingspotRepository.findById(id);

   }


   public boolean existsByLicensePlateCar(String licensePlatecar){
      return parkingspotRepository.existsByLicensePlateCar(licensePlatecar);
   }

   public boolean existsByParkingSpotNumber(String parkingSpotNumber){
      return parkingspotRepository.existsByParkingSpotNumber(parkingSpotNumber);
   }

   public boolean existsByApartmentAndBlock(String apartament, String block){
      return parkingspotRepository.existsByApartmentAndBlock(apartament,block);
   }



}
