/**
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation, version 3.</p>
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.</p>
 *
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 *
 */
package com.francisli.processing.dotenv;

import java.util.Map;
import java.util.HashMap;
import processing.core.PApplet;

/**
 * <p>The DotEnv class provides the interface for accessing environment
 * variables including local overrides in a file in the sketch folder.</p>
 *
 * @author Francis Li
 * @usage Application
 * @param dotenv DotEnv: any variable of type DotEnv
 */
public class DotEnv {
    Map<String, String> system;
    Map<String, String> sketch;

    public DotEnv(PApplet parent) {
      this(parent, ".env");
    }

    /** Returns a new DotEnv instance used to access environment variables
     *
     * @param parent PApplet: typically use "this"
     * @param filename String: name of file in the sketch folder that contains variable overrides (defaults to .env if not specified)
     */
    public DotEnv(PApplet parent, String filename) {
        this.system = System.getenv();
        this.sketch = new HashMap<String, String>();
        String[] lines = parent.loadStrings(filename);
        for (String line: lines) {
            String[] tokens = line.split("=");
            if (tokens.length == 2) {
                sketch.put(tokens[0], tokens[1]);
            }
        }
    }


    /** Returns the value for a given environment variable.
     *
     * @param key String: name of the environment variable whose value you wish to fetch
     * @return String: value of environment variable, or null if not defined
     */
    public String get(String key) {
        String value = sketch.get(key);
        if (value == null) {
            value = system.get(key);
        }
        return value;
    }
}
