package com.github.newstelegrambot.newstelegrambot.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@Builder
@Getter
public class ParamRequests {

    private final Double lat;
    private final Double lon;
    private final Integer days;
    private final String KEY;

    public Map populateQueries() {
        Map queries = new HashMap<>();
        if(nonNull(lat)) {
            queries.put("lat", lat);
        }
        if(nonNull(lon)) {
            queries.put("lon", lon);
        }
        if(nonNull(days)) {
            queries.put("days", days);
        }
        if(nonNull(days)) {
            queries.put("key", KEY);
        }
    return queries;
    }
}

