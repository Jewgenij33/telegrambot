package com.github.newstelegrambot.newstelegrambot.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@Builder
@Getter
public class ParamRequests {

    private final String query;
    private final double lat;
    private final double lon;
    private final Integer days;
    private final String KEY;

    public Map populateQueries() {
        Map queries = new HashMap<>();
        if(nonNull(query)) {
            queries.put("query", query);
        }
        if(nonNull(lat)) {
            queries.put("lat", lat);
        }
        if(nonNull(lon)) {
            queries.put("lon", lon);
        }
        if(nonNull(days)) {
            queries.put("days", days);
        }
        queries.put("key", KEY);
    return queries;
    }
}

