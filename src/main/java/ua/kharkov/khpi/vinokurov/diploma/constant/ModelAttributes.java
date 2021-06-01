package ua.kharkov.khpi.vinokurov.diploma.constant;

public final class ModelAttributes {
    public static final String CITIES = "cities";
    public static final String ROUTES = "routes";
    public static final String COUNTRIES = "countries";
    public static final String SEATS = "seats";
    public static final String PLANES = "planes";
    public static final String STATIONS = "stations";
    public static final String SINGLE_FLIGHTS = "single_flights";

    public static final String PAGE_ATTRIBUTE = "page";
    public static final String SIZE_ATTRIBUTE = "size";
    public static final int DEFAULT_PAGE_SIZE = 10;

    private ModelAttributes() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
