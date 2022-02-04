package com.isladellago.apartmentmanager.util;

public final class PathUtils {

    public static final String BASE_PATH = "/api/v1/apartment";

    public static final String HEALTH = "/health";

    public static final String APARTMENT_BY_ID = "/apartmentId/{apartmentId}";

    private PathUtils() {
        throw new AssertionError();
    }
}
