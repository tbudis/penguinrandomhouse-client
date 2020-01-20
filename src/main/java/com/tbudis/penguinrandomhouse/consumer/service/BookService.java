package com.tbudis.penguinrandomhouse.consumer.service;

import com.tbudis.penguinrandomhouse.consumer.model.Work;
import com.tbudis.penguinrandomhouse.consumer.rest_client.WorkClient;
import com.tbudis.penguinrandomhouse.consumer.util.NameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Book management service.
 *
 * @author titus
 * @since 2020-01-20
 */
@Service
public class BookService {

    /** Rest client for retrieving Work data. */
    @Autowired
    private WorkClient workClient;

    /**
     * Get authors information by book name.
     * Convert the authors name into [firstName lastName] format.
     *
     * @param bookName The book name
     * @return Name of authors
     */
    public String getAuthorsByBookName(String bookName) {
        Optional<Work> result = workClient.findByName(bookName);
        if (!result.isPresent()) {
            return null;
        }

        Work work = result.get();
        return NameUtil.convert(work.getAuthorweb());
    }
}
