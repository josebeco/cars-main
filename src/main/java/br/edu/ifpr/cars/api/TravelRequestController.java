package br.edu.ifpr.cars.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifpr.cars.domain.Driver;
import br.edu.ifpr.cars.domain.DriverRepository;
import br.edu.ifpr.cars.domain.PassengerRepository;
import br.edu.ifpr.cars.domain.TravelRequest;
import br.edu.ifpr.cars.domain.TravelRequestRepository;
import br.edu.ifpr.cars.domain.TravelRequestStatus;

@Service
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class TravelRequestController {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    TravelRequestRepository travelRequestRepository;

    @GetMapping("/travels")
    public List<TravelRequest> listTravels() {
        return travelRequestRepository.findAll();
    }

    @GetMapping("/travels/{id}")
    public TravelRequest findTravel(@PathVariable("id") Long id) {
        return travelRequestRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/travels")
    public TravelRequest createTravel(@RequestBody TravelRequest travelRequest) {
        return travelRequestRepository.save(travelRequest);
    }

    @PutMapping("/travels/{travelId}/driver/{driverId}")
    public TravelRequest assignDriverToTravel(
            @PathVariable("travelId") Long travelId,
            @PathVariable("driverId") Long driverId) {

        TravelRequest travel = travelRequestRepository.findById(travelId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (travel.getStatus() != TravelRequestStatus.CREATED) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        travel.setStatus(TravelRequestStatus.ACCEPTED);

        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        travel.setDriver(driver);
        return travelRequestRepository.save(travel);
    }

   
    @PatchMapping("/travels/{id}")
    public TravelRequest updateTravelStatus(@PathVariable("id") Long id,
            @RequestBody TravelRequest travelRequest) {
        TravelRequest foundTravel = findTravel(id);
        foundTravel.setStatus(Optional.ofNullable(travelRequest.getStatus())
                .orElse(foundTravel.getStatus()));
        return travelRequestRepository.save(foundTravel);
    }
    @DeleteMapping("/travels/{id}")
    public void deleteTravel(@PathVariable("id") Long id) {
        travelRequestRepository.deleteById(id);
    }

}
