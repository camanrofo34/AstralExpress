package Model.Environment;

import DataStructures.ArrayList;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Environment {
    private static Environment instance;
    private final ArrayList<String> variables;

    private Environment() {
        variables = new ArrayList<>();
        loadVariables(getPathProperties());
    }
    private String getPathProperties() {
        return "src/main/resources/Model/server.properties";
    }

    private void loadVariables(String path) {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            properties.load(fileInputStream);
            String[] port = (properties.getProperty("PORTS")).split(",");
            String[] service = (properties.getProperty("SERVICES")).split(",");

            variables.add("IP,"+(String) properties.get("IP"));

            variables.add("PORT0," + port[0]);
            variables.add("SERVICE0," + service[0]);

            variables.add("PORT1," + port[1]);
            variables.add("SERVICE1," + port[1]);

            variables.add("JSON-PATH," + properties.getProperty("JSON-PATH"));
        } catch (Exception exception) {
            Logger.getLogger("Server").log(Level.WARNING, exception.getMessage(), exception);
        }
    }

    public static Environment getInstance() {
        if (Environment.instance == null) Environment.instance = new Environment();

        return Environment.instance;
    }

    public Map<String, String> getVariables() { return variables; }
}

