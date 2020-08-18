package com.internalization.classes;

import com.internalization.constants.ZoneIdConstant;

public class CommonZoneIdHolder {

    private static ThreadLocal<ZoneIdHolder> zoneIdHolder = new ThreadLocal<>();

    public static void setZoneId(ZoneIdConstant zoneIdCOnstant) {
        zoneIdHolder.set(ZoneIdHolder.atZone(zoneIdCOnstant));
    }

    public static ZoneIdHolder getZoneIdHolder() {
        return zoneIdHolder.get();
    }

    public static void setDefaultZoneId() {
        zoneIdHolder.set(ZoneIdHolder.atDefaultZone());
    }
}
