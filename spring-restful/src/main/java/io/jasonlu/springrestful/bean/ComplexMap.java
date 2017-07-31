package io.jasonlu.springrestful.bean;

import java.util.List;
import java.util.Map;

/**
 * Created by jiehenglu on 17/07/15.
 */
public class ComplexMap {

    private String id;
    private String name;

    private Map<String, List<Map<String, String>>> body;

    public ComplexMap(String id, String name, Map<String, List<Map<String, String>>> body) {
        this.id = id;
        this.name = name;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Map<String, String>>> getBody() {
        return body;
    }
}
