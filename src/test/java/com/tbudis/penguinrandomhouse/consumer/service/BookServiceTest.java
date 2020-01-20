package com.tbudis.penguinrandomhouse.consumer.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Book service management test.
 *
 * @author titus
 * @since 2020-01-20
 */
@SpringBootTest
public class BookServiceTest {

    /** Book service. */
    @Autowired
    private BookService bookService;

    /**
     * Test retrieving authors by book name.
     */
    @Test
    public void test_authors() {

        // test result with single Work data
        assertEquals("Dan Howell",
                bookService.getAuthorsByBookName("The Amazing Book Is Not on Fire: The World of Dan and Phil"));

        assertEquals("RANDOM HOUSE",
                bookService.getAuthorsByBookName("Paw Patrol 5-Minute Stories Collection (Paw Patrol)"));

        // test result with multiple Work data
        assertEquals("Alfie Kohn", bookService.getAuthorsByBookName("Educated"));

        // test empty result
        assertNull(bookService.getAuthorsByBookName("$@#$%!@^$!^%@%$^!"));
    }
}
