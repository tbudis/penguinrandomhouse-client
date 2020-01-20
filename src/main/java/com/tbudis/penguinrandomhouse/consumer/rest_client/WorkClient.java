package com.tbudis.penguinrandomhouse.consumer.rest_client;

import com.tbudis.penguinrandomhouse.consumer.configuration.ConfigProperties;
import com.tbudis.penguinrandomhouse.consumer.model.Work;
import com.tbudis.penguinrandomhouse.consumer.model.Works;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

/**
 * REST client to retrieve Work data information from the resource provider.
 *
 * @author titus
 * @since 2020-01-20
 */
@Service
public class WorkClient {

    /** The maximum number of returned results. */
    private static final int MAX_RESULTS = 4;

    /** Configuration properties. */
    @Autowired
    private ConfigProperties configProperties;

    /** Spring Rest template. */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Find Work data related to the supplied book name (exact match).
     *
     * @param bookName Book name
     * @return Work data
     */
    public Optional<Work> findByName(String bookName) {

        // build full url with provided query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(configProperties.getWorkUrl())
                .queryParam("start", 0)
                .queryParam("max", MAX_RESULTS)
                .queryParam("expandLevel", 1)
                .queryParam("search", bookName);

        // encode the complete url properly because we pass book name as one of the query parameter
        UriComponents uriComponents = builder.build().encode();

        // convert json response string into its POJO representation
        Works works = restTemplate.getForObject(uriComponents.toUri(), Works.class);

        // for POC, if there is no result just returns empty
        // TODO throw custom exception
        if (works.getWork() == null || works.getWork().length == 0) {
            return Optional.empty();
        }

        // for POC, only the first result is returned
        Work selectedWork = works.getWork()[0];
        return Optional.of(selectedWork);
    }
}
