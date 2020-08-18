package com.internalization.classes;

import com.internalization.constants.ZoneIdConstant;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneIdHolder {

    private final ZoneId zoneId;

    private ZoneIdHolder() {
        this.zoneId = ZoneId.of(ZoneIdConstant.UTC.value());
    }

    private ZoneIdHolder(ZoneIdConstant zoneId) {
        this.zoneId = ZoneId.of(zoneId.value());
    }

    public static ZoneIdHolder atDefaultZone() {
        return new ZoneIdHolder();
    }

    public static ZoneIdHolder atZone(ZoneIdConstant zoneId) {
        return new ZoneIdHolder(zoneId);
    }

    public ZoneId getZoneId() {
        return this.zoneId;
    }

    public Instant getInstant() {
        return Instant.now();
    }

    public ZonedDateTime getZoneDateTime() {
        return this.getZoneDateTime(Instant.now());
    }

    public ZonedDateTime getZoneDateTime(Instant instant) {
        return this.getZoneDateTime(instant, this.getZoneId());
    }

    public ZonedDateTime getZoneDateTime(Instant instant, ZoneId zoneId) {
        return ZonedDateTime.ofInstant(instant, zoneId);
    }

    public LocalDateTime toLocalDateTime(ZonedDateTime zonedDateTime) {
        return zonedDateTime.toLocalDateTime();
    }

    public LocalDateTime now() {
        return this.toLocalDateTime(Instant.now(), this.getZoneId());
    }

    public LocalDateTime toLocalDateTime(Instant instant) {
        return this.toLocalDateTime(this.getZoneDateTime(instant));
    }

    public LocalDateTime toLocalDateTime(Instant instant, ZoneId zoneId) {
        return this.toLocalDateTime(this.getZoneDateTime(instant, zoneId));
    }

}
