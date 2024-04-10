package Model.Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RMIServer {
    private final String ip;
    private final String port;
    private final String url;
    private final String serviceName;
    private final Remote service;

    public RMIServer(String ip, String port, String serviceName, Remote service)  {
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.service = service;
        this.url = "//" + ip + ":" + port + "/" + serviceName;
    }

    public boolean deploy() {
        if (ip == null || port == null || serviceName == null) return false;

        try {
            System.setProperty("java.rmi.server.hostname", ip);
            LocateRegistry.createRegistry(Integer.parseInt(port));
            Naming.rebind(url, service);
            Logger.getLogger(this.getClass().getSimpleName()).log(Level.INFO, "Service is running on {0}", url);

            return true;
        } catch (RemoteException | MalformedURLException exception) {
            Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, exception.getMessage(), exception);
        }

        return false;
    }

    public boolean undeploy() {
        try {
            Naming.unbind(url);
            return true;
        } catch (RemoteException | MalformedURLException | NotBoundException exception) {
            Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, exception.getMessage(), exception);
        }

        return false;
    }
}
