package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class TestGeoService {
    @org.junit.jupiter.api.Test
    void testGeoService() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = new Location("New York", Country.USA, " 10th Avenue", 32);
        Location locationRu = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location locationGeo = geoService.byIp("96.44.183.149");
        Location locationGeoRu = geoService.byIp("172.0.32.11");
        Assertions.assertEquals(location.getCity(), locationGeo.getCity());
        Assertions.assertEquals(locationRu.getCity(), locationGeoRu.getCity());
    }
}
