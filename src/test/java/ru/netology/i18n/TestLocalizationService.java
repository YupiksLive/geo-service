package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class TestLocalizationService {
    @org.junit.jupiter.api.Test
    void testLocalizationService() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        Country country = Country.RUSSIA;
        Country countryUSA = Country.USA;
        Assertions.assertEquals("Добро пожаловать", localizationService.locale(country));
        Assertions.assertEquals("Welcome", localizationService.locale(countryUSA));
    }
}
