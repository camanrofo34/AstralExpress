/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC 4060TI
 */
public class RMISettings {

    private static RMISettings instance;
    private String ip;
    private String port;
    private String serviceName;
    private String uri;

    private RMISettings() {
        Properties config = new Properties();
        try (FileInputStream fin = new FileInputStream(new File("config.properties"))) {
            config.load(fin);
            ip = (String) config.get("IP");
            port = (String) config.get("PORT");
            serviceName = (String) config.get("SERVICE_NAME");
            this.uri = "//" + this.ip + ":" + this.port + "/" + this.serviceName;
        } catch (Exception e) {
            Logger.getLogger("AuthServer").log(Level.WARNING, e.getMessage(), e);
        }
    }

    public static synchronized RMISettings getInstance() {
        if (instance == null) {
            instance = new RMISettings();
        }
        return instance;
    }

    public String getRMIAddress() {
        return uri;
    }
}
