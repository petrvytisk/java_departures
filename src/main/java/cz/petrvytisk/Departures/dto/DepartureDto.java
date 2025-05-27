package cz.petrvytisk.Departures.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepartureDto {
    @JsonProperty("icao24")
    private String icao24;

    @JsonProperty("firstSeen")
    private long firstSeen;

    @JsonProperty("estDepartureAirport")
    private String estDepartureAirport;

    @JsonProperty("lastSeen")
    private long lastSeen;

    @JsonProperty("estArrivalAirport")
    private String estArrivalAirport;

    @JsonProperty("callsign")
    private String callsign;

    @JsonProperty("estDepartureAirportHorizDistance")
    private Integer estDepartureAirportHorizDistance;

    @JsonProperty("estDepartureAirportVertDistance")
    private Integer estDepartureAirportVertDistance;

    @JsonProperty("estArrivalAirportHorizDistance")
    private Integer estArrivalAirportHorizDistance;

    @JsonProperty("estArrivalAirportVertDistance")
    private Integer estArrivalAirportVertDistance;

    @JsonProperty("departureAirportCandidatesCount")
    private Integer departureAirportCandidatesCount;

    @JsonProperty("arrivalAirportCandidatesCount")
    private Integer arrivalAirportCandidatesCount;

    // Getter and Setter
    public String getIcao24() {
        return icao24;
    }

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }

    public long getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(long firstSeen) {
        this.firstSeen = firstSeen;
    }

    public String getEstDepartureAirport() {
        return estDepartureAirport;
    }

    public void setEstDepartureAirport(String estDepartureAirport) {
        this.estDepartureAirport = estDepartureAirport;
    }

    public long getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(long lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getEstArrivalAirport() {
        return estArrivalAirport;
    }

    public void setEstArrivalAirport(String estArrivalAirport) {
        this.estArrivalAirport = estArrivalAirport;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public Integer getEstDepartureAirportHorizDistance() {
        return estDepartureAirportHorizDistance;
    }

    public void setEstDepartureAirportHorizDistance(Integer estDepartureAirportHorizDistance) {
        this.estDepartureAirportHorizDistance = estDepartureAirportHorizDistance;
    }

    public Integer getEstDepartureAirportVertDistance() {
        return estDepartureAirportVertDistance;
    }

    public void setEstDepartureAirportVertDistance(Integer estDepartureAirportVertDistance) {
        this.estDepartureAirportVertDistance = estDepartureAirportVertDistance;
    }

    public Integer getEstArrivalAirportHorizDistance() {
        return estArrivalAirportHorizDistance;
    }

    public void setEstArrivalAirportHorizDistance(Integer estArrivalAirportHorizDistance) {
        this.estArrivalAirportHorizDistance = estArrivalAirportHorizDistance;
    }

    public Integer getEstArrivalAirportVertDistance() {
        return estArrivalAirportVertDistance;
    }

    public void setEstArrivalAirportVertDistance(Integer estArrivalAirportVertDistance) {
        this.estArrivalAirportVertDistance = estArrivalAirportVertDistance;
    }

    public Integer getDepartureAirportCandidatesCount() {
        return departureAirportCandidatesCount;
    }

    public void setDepartureAirportCandidatesCount(Integer departureAirportCandidatesCount) {
        this.departureAirportCandidatesCount = departureAirportCandidatesCount;
    }

    public Integer getArrivalAirportCandidatesCount() {
        return arrivalAirportCandidatesCount;
    }

    public void setArrivalAirportCandidatesCount(Integer arrivalAirportCandidatesCount) {
        this.arrivalAirportCandidatesCount = arrivalAirportCandidatesCount;
    }
}
