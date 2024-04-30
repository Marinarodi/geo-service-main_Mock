package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.geo.GeoServiceImpl;

import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MessageSenderImplTest_RU {
    @Mock
    GeoServiceImpl mock_geoService;

    @Mock
    Country country;
    @InjectMocks
    MessageSenderImpl mock_messageSender;

   @Test
    void testSend (){
       String ipAddress = "172.";
       when(mock_geoService.byIp(Mockito.anyString())).thenReturn(Set.of(GeoServiceImpl.MOSCOW_IP, GeoServiceImpl.NEW_YORK_IP));

       GeoServiceImpl geoService = new GeoServiceImpl(mock_geoService);

       GeoServiceImpl  expected = (GeoServiceImpl) Set.of(GeoServiceImpl.MOSCOW_IP);
       GeoServiceImpl  actual =  mock_messageSender.send(mock_geoService.byIp(ipAddress));

       Assertions.assertEquals(expected, actual);

   }
}
