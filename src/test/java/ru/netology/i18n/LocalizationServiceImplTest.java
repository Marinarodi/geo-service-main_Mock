package ru.netology.i18n;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;
public class LocalizationServiceImplTest {

    @Test
    void test_locale() {
    LocalizationServiceImpl mockLocal = Mockito.mock(LocalizationServiceImpl.class);
    Mockito.when(mockLocal.locale(Country.RUSSIA)).thenReturn( "Добро пожаловать");

        String  expected = "Добро пожаловать";
        String  actual =  mockLocal.locale(Country.RUSSIA);

        Assertions.assertEquals(expected, actual);


    }

}
