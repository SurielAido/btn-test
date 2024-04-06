package org.example.shared.domain.vo;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.*;
import java.util.List;

@EqualsAndHashCode
public class ZonedDateTimeValueObject implements Serializable {

    protected final ZonedDateTime value;

    public ZonedDateTimeValueObject(ZonedDateTime value) {
        this.value = value;
    }

    protected static ZonedDateTime castTimestampToZonedDateTime(Timestamp timestamp) {
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        return localDateTime.atZone(ZoneId.systemDefault());
    }

    protected static Timestamp castZonenddateTimeToTimestap(ZonedDateTime zonedDateTime) {
        Instant instant = zonedDateTime.toInstant();
        return Timestamp.from(instant);
    }

    protected static ZonedDateTime castStringToZonedDateTime(String zonedDateTimeAsString) {
        List<String> date = List.of(zonedDateTimeAsString.split("-"));
        Integer year = Integer.parseInt(date.get(0));
        Integer month = Integer.parseInt(date.get(1));
        Integer day = Integer.parseInt(date.get(2));
        LocalDate localDate = LocalDate.of(year, month, day);

        List<String> time = List.of(date.get(3).replace(".", "-").split("-"));
        Integer hour = Integer.parseInt(time.get(0));
        Integer min = Integer.parseInt(time.get(1));
        Integer sec = Integer.parseInt(time.get(2));
        LocalTime localTime = LocalTime.of(hour, min, sec);

        return ZonedDateTime.of(localDate, localTime, ZoneId.systemDefault());
    }

    public ZonedDateTime value() {
        return value;
    }
}
