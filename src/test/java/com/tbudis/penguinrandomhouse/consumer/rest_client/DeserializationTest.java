package com.tbudis.penguinrandomhouse.consumer.rest_client;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tbudis.penguinrandomhouse.consumer.model.Work;
import com.tbudis.penguinrandomhouse.consumer.model.Works;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Deserialisation test.
 *
 * @author titus
 * @since 2020-01-20
 */
public class DeserializationTest {

    /**
     * Test deserialising single Work data.
     *
     * @throws IOException
     */
    @Test
    public void testSingleWork() throws IOException {
        InputStream inputStream = DeserializationTest.class.getResourceAsStream("/single_work.json");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        Works works = objectMapper.readValue(inputStream, Works.class);

        assertEquals(1, works.getWork().length);

        Work work = works.getWork()[0];
        assertEquals("HOWELL, DAN", work.getAuthorweb());
        assertEquals("The Amazing Book Is Not on Fire", work.getTitleweb());
    }

    /**
     * Test deserialising multiple Work data.
     *
     * @throws IOException
     */
    @Test
    public void testMultipleWorks() throws IOException {
        InputStream inputStream = DeserializationTest.class.getResourceAsStream("/multiple_works.json");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        Works works = objectMapper.readValue(inputStream, Works.class);

        assertEquals(2, works.getWork().length);

        Work work1 = works.getWork()[0];
        assertEquals("KOHN, ALFIE", work1.getAuthorweb());
        assertEquals("What Does It Mean to Be Well Educated?", work1.getTitleweb());

        Work work2 = works.getWork()[1];
        assertEquals("GRAHAM, SHEILAH", work2.getAuthorweb());
        assertEquals("College of One", work2.getTitleweb());
    }
}
