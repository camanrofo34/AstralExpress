package Model.Environment;

import dataStructures.ArrayList;

import java.io.FileInputStream;
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
        return "src\\main\\resources\\Model\\server.properties";
    }

    private void loadVariables(String path) {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            properties.load(fileInputStream);
            String[] port = (properties.getProperty("PORTS")).split(",");
            String[] service = (properties.getProperty("SERVICES")).split(",");
            variables.add((String) properties.get("IP"));
            variables.add(port[0]);
            variables.add(service[0]);
            variables.add(properties.getProperty("JSON-PATH"));
            variables.add(port[1]);
            variables.add(service[1]);
            variables.add(port[2]);
            variables.add(service[2]);
        } catch (Exception exception) {
            Logger.getLogger("Server").log(Level.WARNING, exception.getMessage(), exception);
        }
    }

    public static Environment getInstance() {
        if (Environment.instance == null) Environment.instance = new Environment();
        return Environment.instance;
    }

    public ArrayList<String> getVariables() { return variables; }
}

