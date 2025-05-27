package cz.petrvytisk.Departures.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class TimeConverter {
    // Formatter pro vstupní formát RRRRMMDDHHMM, např. "202501241530"
    private static final DateTimeFormatter INPUT_FORMAT =
            DateTimeFormatter.ofPattern("yyyyMMddHHmm");

    /**
     * Převede řetězec ve formátu "yyyyMMddHHmm" zóny UTC na Unix timestamp (sekundy UTC).
     *
     * @param dateTimeStr např. "202501241530"
     * @return počet sekund od 1.1.1970 00:00:00 UTC
     */
    public static long toEpochSecondsUTC(String dateTimeStr) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, INPUT_FORMAT);
        return localDateTime.toEpochSecond(ZoneOffset.UTC);
    }

    public static long toEpochSecondsUTC(LocalDateTime dateTime) {
        return dateTime.toEpochSecond(ZoneOffset.UTC);
    }
}
