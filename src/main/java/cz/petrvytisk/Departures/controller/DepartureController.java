package cz.petrvytisk.Departures.controller;

import cz.petrvytisk.Departures.dto.DepartureDto;
import cz.petrvytisk.Departures.service.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odlety")
public class DepartureController {

    @Autowired
    private DepartureService departureService;

    // S parametry jako query string
    // Volání: GET /odlety?letiste=EDDF&od=1517227200&do=1517230800
    @GetMapping(params = {"letiste", "od", "do"})
    public List<DepartureDto> getAirportDepartures(
            @RequestParam("letiste") String airportICAO,
            @RequestParam("od") String beginTime,
            @RequestParam("do") String endTime) {
        return departureService.getAirportDepartures(airportICAO, beginTime, endTime);
    }
}