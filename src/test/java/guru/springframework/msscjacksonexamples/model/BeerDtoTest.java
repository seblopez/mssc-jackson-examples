package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;
import java.text.MessageFormat;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@JsonTest
class BeerDtoTest extends BaseTest {

    @Test
    void testSerializeDtoOk() throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(getDto());

        assertNotNull(jsonString);
        assertTrue(jsonString.contains("Andes"));

        log.info(MessageFormat.format("Serialized POJO: {0}", jsonString));
    }

    @Test
    void testDeserializeDtoOk() throws IOException {
        String json = "{\"beerName\":\"Andes\",\"beerStyle\":\"Honey\",\"upc\":12132312323,\"price\":\"12.99\",\"createdDate\":\"2020-07-30T18:25:37.478372-03:00\",\"lastUpdatedDate\":\"2020-07-30T18:25:37.47843-03:00\",\"myLocalDate\":\"20200730\",\"beerId\":\"01c161bc-7400-4ea2-9dca-d0040c6fa7bc\"}";

        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);

        assertNotNull(beerDto);
        assertEquals("01c161bc-7400-4ea2-9dca-d0040c6fa7bc", beerDto.getId().toString());
        assertEquals("Andes", beerDto.getBeerName());

        log.info(MessageFormat.format("Deserialized String: {0}", beerDto));

    }

}
