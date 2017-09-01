package com.francisli.processing.dotenv;

import java.util.Map;
import java.util.HashMap;
import processing.core.PApplet;

public class DotEnv {
    protected Map<String, String> system;
    protected Map<String, String> sketch;

    public DotEnv(PApplet parent) {
        this.system = System.getenv();
        this.sketch = new HashMap<String, String>();
        String[] lines = parent.loadStrings(".env");
        for (String line: lines) {
            String[] tokens = line.split("=");
            if (tokens.length == 2) {
                sketch.put(tokens[0], tokens[1]);
            }
        }
    }

    public String get(String key) {
        String value = sketch.get(key);
        if (value == null) {
            value = system.get(key);
        }
        return value;
    }
}
