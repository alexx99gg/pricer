package com.sillycom.pricer.integration;

import com.google.gson.Gson;
import com.sillycom.pricer.PricerApplication;
import com.sillycom.pricer.infrastructure.dto.response.PriceDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {PricerApplication.class})
@ActiveProfiles("test")
@AutoConfigureMockMvc
class PriceControllerTest {

  DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

  Gson gson = new Gson();
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private Clock clock;

  /*
  Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
  Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
  Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
  Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
  Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
   */
  @ParameterizedTest
  @CsvSource({
      "35455,1,2020-06-14-10.00.00,35.50"
  })
  void getPriceTest(Integer brand, Integer product, String date, Double priceExpected) throws Exception {

    LocalDateTime localDateTime = LocalDateTime.parse(date, dateTimeFormatter);
    Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
    Mockito.when(clock.instant()).thenReturn(instant);

    String jsonResult = this.mockMvc.perform(get("/price/" + brand + "/" + product))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    PriceDto priceDto = gson.fromJson(jsonResult, PriceDto.class);

    Assertions.assertEquals(priceExpected, priceDto.getPrice());
  }

}
