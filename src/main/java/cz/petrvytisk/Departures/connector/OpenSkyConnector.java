package cz.petrvytisk.Departures.connector;

import cz.petrvytisk.Departures.dto.DepartureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@Component
public class OpenSkyConnector {
    private final RestTemplate restTemplate;
    private static String baseUrl = "https://opensky-network.org/api/";
    private static String endpoint = "flights/departure";

    @Autowired
    public OpenSkyConnector(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Vystavit api url např. GET /api/odlety?letiste=xxxx&od=RRRRMMDDHHMM&do=RRRRMMDDHHMM
    //https://opensky-network.org/api/flights/departure?airport=LKMT&begin=1517227200&end=1517230800

    public List<DepartureDto> getAirportDepartures(String airportICAO, long beginTime, long endTime) {
        URI uri = null;
        try {
            uri = new URI(baseUrl + endpoint +
                    "?airport=" + airportICAO +
                    "&begin=" + beginTime +
                    "&end=" + endTime);
        } catch (URISyntaxException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
        ResponseEntity<DepartureDto[]> response = restTemplate.getForEntity(uri, DepartureDto[].class);
        return Arrays.asList(response.getBody());
    }
}
