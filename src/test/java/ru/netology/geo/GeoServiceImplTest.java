package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.geo.GeoServiceImpl;

import java.util.Set;

public class GeoServiceImplTest {
    @Test
    void test_byIp() {
        GeoServiceImpl mock_byIp = Mockito.mock(GeoServiceImpl.class);
        String ipAddress = "172.";

        Mockito.when(mock_byIp.byIp(ipAddress)).thenReturn(Set.of(GeoServiceImpl.MOSCOW_IP, GeoServiceImpl.NEW_YORK_IP));

        GeoServiceImpl geoService = new GeoServiceImpl(mock_byIp);

        GeoServiceImpl  expected = (GeoServiceImpl) Set.of(GeoServiceImpl.MOSCOW_IP);
        GeoServiceImpl  actual =  mock_byIp.byIp(ipAddress);

        Assertions.assertEquals(expected, actual);


    }
    
}
