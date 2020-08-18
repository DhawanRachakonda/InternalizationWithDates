package com.internalization.constants;

public enum ZoneIdConstant {
    ASIA_KOLKATA("Asia/Kolkata"),
    Europe_Dublin("Europe/Dublin"),
    UTC("UTC");

    private String name;

    ZoneIdConstant(String zoneName) {
        this.name = zoneName;
    }

    public String value() {
        return this.name;
    }

    public ZoneIdConstant toZoneIdConstant(final String zoneId) {
        if(zoneId == ZoneIdConstant.ASIA_KOLKATA.value()) {
            return ZoneIdConstant.ASIA_KOLKATA;
        } else if(zoneId == ZoneIdConstant.Europe_Dublin.value()) {
            return ZoneIdConstant.Europe_Dublin;
        } else if(zoneId == ZoneIdConstant.UTC.value()) {
            return ZoneIdConstant.UTC;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
