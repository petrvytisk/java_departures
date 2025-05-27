package cz.petrvytisk.Departures.service;

import cz.petrvytisk.Departures.connector.OpenSkyConnector;
import cz.petrvytisk.Departures.dto.DepartureDto;
import cz.petrvytisk.Departures.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepartureService {
    private final OpenSkyConnector connector;
    @Autowired
    public DepartureService(OpenSkyConnector connector) {
        this.connector = connector;
    }
    // stávající metoda pro API (String)
    public List<DepartureDto> getAirportDepartures(String airportICAO, String beginTime, String endTime) {
        long beginTimestamp = TimeConverter.toEpochSecondsUTC(beginTime);
        long endTimestamp   = TimeConverter.toEpochSecondsUTC(endTime);
        return connector.getAirportDepartures(airportICAO, beginTimestamp, endTimestamp);
    };

    // nová metoda pro web (LocalDateTime)
    public List<DepartureDto> findDepartures(String airportICAO,
                                             LocalDateTime from,
                                             LocalDateTime to) {
        long beginTs = TimeConverter.toEpochSecondsUTC(from);
        long endTs   = TimeConverter.toEpochSecondsUTC(to);
        return connector.getAirportDepartures(airportICAO, beginTs, endTs);
    }
}
