import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

class TestMessageSender {

    @org.junit.jupiter.api.Test
    void testMessageSenderUSA() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(Mockito.eq("96.44.183.149"))).thenReturn(new Location(null, Country.USA, null, 0));
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Mockito.eq(Country.USA))).thenReturn("Welcome");
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Assertions.assertEquals("Welcome", messageSender.send(headers));
    }

    @org.junit.jupiter.api.Test
    void testMessageSenderRus() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(Mockito.eq("172.0.32.11"))).thenReturn(new Location(null, Country.RUSSIA, null, 0));
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Mockito.eq(Country.RUSSIA))).thenReturn("Добро пожаловать");
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Assertions.assertEquals("Добро пожаловать", messageSender.send(headers));
    }
}

class TestGeoService {
    @org.junit.jupiter.api.Test
    void testGeoService() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = new Location("New York", Country.USA, " 10th Avenue", 32);
        Location locationGeo = geoService.byIp("96.44.183.149");
        Assertions.assertEquals(location.getCity(), locationGeo.getCity());
    }
}
class TestLocalizationService {
    @org.junit.jupiter.api.Test
    void testLocalizationService() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        Country country = Country.RUSSIA;
        Assertions.assertEquals("Добро пожаловать", localizationService.locale(country));
    }
}
