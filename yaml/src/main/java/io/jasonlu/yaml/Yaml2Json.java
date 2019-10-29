package io.jasonlu.yaml;

import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class Yaml2Json {
    public static void main(String[] args) {
        Gson gs = new Gson();
        Yaml yaml = new Yaml();
        Map<String, Object> loaded = yaml.load(Yaml2Json.class.getResourceAsStream("/demo.yaml"));
        System.out.println(gs.toJson(loaded));
    }
}
